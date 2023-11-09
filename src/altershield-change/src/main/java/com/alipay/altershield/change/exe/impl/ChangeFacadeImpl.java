/*
 * MIT License
 *
 * Copyright (c) [2023]
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
/*
 * Copyright Notice: This software is developed by Ant Small and Micro Financial Services Group Co., Ltd. This software and
 *  all the relevant information, including but not limited to any signs, images, photographs, animations, text,
 *  interface design, audios and videos, and printed materials, are protected by copyright laws and other intellectual
 *  property laws and treaties.
 *
 * The use of this software shall abide by the laws and regulations as well as Software Installation License
 * Agreement/Software Use Agreement updated from time to time. Without authorization from Ant Small and Micro Financial
 *  Services Group Co., Ltd., no one may conduct the following actions:
 *
 *   1) reproduce, spread, present, set up a mirror of, upload, download this software;
 *
 *   2) reverse engineer, decompile the source code of this software or try to find the source code in any other ways;
 *
 *   3) modify, translate and adapt this software, or develop derivative products, works, and services based on this
 *    software;
 *
 *   4) distribute, lease, rent, sub-license, demise or transfer any rights in relation to this software, or authorize
 *    the reproduction of this software on other’s computers.
 */
package com.alipay.altershield.change.exe.impl;

import com.alipay.altershield.change.exe.service.check.ChangeTraceService;
import com.alipay.altershield.change.exe.service.check.ExeChangeAsyncCheckService;
import com.alipay.altershield.change.exe.service.check.ExeChangeOrderService;
import com.alipay.altershield.change.exe.service.check.ExeChangeSyncCheckService;
import com.alipay.altershield.change.meta.service.MetaChangeSceneService;
import com.alipay.altershield.framework.core.change.facade.ChangeFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Ops cloud change facade.
 *
 * @author yuanji
 * @version : OpsCloudChangeFacadeImpl.java, v 0.1 2022年02月15日 4:00 下午 yuanji Exp $
 */
@Service
public class ChangeFacadeImpl implements ChangeFacade {

    @Autowired
    private ExeChangeAsyncCheckService exeChangeAsyncCheckService;

    @Autowired
    private ExeChangeSyncCheckService exeChangeSyncCheckService;

    @Autowired
    private ExeChangeOrderService exeChangeOrderService;

    @Autowired
    private ChangeTraceService changeTraceService;

    @Autowired
    private MetaChangeSceneService metaChangeSceneService;

    /**
     * 提交变更事件
     *
     * @param request
     * @return
     */
    @LogAnnotation(serviceDesc = "submitChangeEvent", digestLogType = DigestLogTypeEnum.SERVICE_OPERATE_DIGEST,
            detailLogType = DetailLogTypeEnum.SERVICE_INFO, keyArg = 0, keyProps = "platform|bizExecOrderId")
    public OpsCloudResult<OpsCloudSubmitChangeEventResult> submitChangeEvent(OpsCloudChangeEventRequest request) {
        return ServiceProcessTemplate.wrapTryCatch(() -> {
            generateOrderTrace(request);
            return exeChangeSyncCheckService.startNotifyService(request);
        });
    }

    @OpsCloudLogAnnotation(serviceDesc = "submitChangeExeOrder", digestLogType = DigestLogTypeEnum.SERVICE_OPERATE_DIGEST,
            detailLogType = DetailLogTypeEnum.SERVICE_INFO, keyArg = 0, keyProps = "platform|bizExecOrderId")
    public OpsCloudResult<OpsCloudSubmitChangeExeOrderResult> submitChangeExeOrder(OpsCloudChangeExecOrderSubmitRequest request) {

        return ServiceProcessTemplate.wrapTryCatch(() -> {

            MetaChangeSceneEntity metaChangeSceneEntity = metaChangeSceneService.getMetaChangeSceneByChangeSceneKey(
                    request.getChangeSceneKey());
            if (metaChangeSceneEntity == null) {
                return OpsCloudResult.illegalArgument("change scene:" + request.getChangeSceneKey() + " not found");
            }
            generateOrderTrace(request);
            OpsCloudChangeExecOrderSubmitRequestModel model = new OpsCloudChangeExecOrderSubmitRequestModel(request);
            model.setStatus(ExeOrderStatusEnum.INIT);
            ExeChangeOrderEntity exeChangeOrderEntity = exeChangeOrderService.createExeChangeOrder(metaChangeSceneEntity, model);

            return OpsCloudResult.succeed("create exec order success",  new OpsCloudSubmitChangeExeOrderResult(exeChangeOrderEntity.getOrderId(),
                    EntityUtil.buildOrderDetailUrl(exeChangeOrderEntity.getOrderId())));
        });
    }

    @OpsCloudLogAnnotation(serviceDesc = "submitChangeStartNotify-createAndStart", digestLogType = DigestLogTypeEnum.SERVICE_OPERATE_DIGEST,
            detailLogType = DetailLogTypeEnum.SERVICE_INFO, keyArg = 0, keyProps = "platform|bizExecOrderId")
    public OpsCloudResult<OpsCloudChangeExecOrderSubmitAndStartResult> submitChangeStartNotify(
            OpsCloudChangeExecOrderSubmitAndStartRequest request) {

        return exeChangeSyncCheckService.startCheckService(request);
    }

    @Override
    @OpsCloudLogAnnotation(serviceDesc = "G2-submitChangeStartNotify", digestLogType = DigestLogTypeEnum.SERVICE_OPERATE_DIGEST,
            detailLogType = DetailLogTypeEnum.SERVICE_INFO, keyArg = 0, keyProps = "platform|bizExecOrderId")
    public OpsCloudResult<OpsCloudChangeNotifySubmitResult> submitChangeStartNotify(
            OpsCloudChangeStartNotifyRequest request) {

        return ServiceProcessTemplate.wrapTryCatch(() -> {
            MetaChangeStepEntity metaChangeStepEntity = queryMetaChangeStepEntity(request);
            generateTrace(request, metaChangeStepEntity);
            return exeChangeAsyncCheckService.startPreCheck(new OpsCloudChangeStartNotifyRequestModel(request, metaChangeStepEntity));
        });
    }

    @Override
    @OpsCloudLogAnnotation(serviceDesc = "retrieveChangeCheckResult", digestLogType = DigestLogTypeEnum.SERVICE_OPERATE_DIGEST,
            detailLogType = DetailLogTypeEnum.SERVICE_INFO, keyArg = 0, keyProps = "platform|bizExecOrderId|nodeId|defenseStage")
    public OpsCloudResult<OpsCloudChangeCheckProgressResult> retrieveChangeCheckResult(
            OpsCloudChangeRetrieveCheckRequest request) {
        return exeChangeAsyncCheckService.retrieveChangeCheckResult(request);
    }

    @Override
    @OpsCloudLogAnnotation(serviceDesc = "submitChangeFinishNotify", digestLogType = DigestLogTypeEnum.SERVICE_OPERATE_DIGEST,
            detailLogType = DetailLogTypeEnum.SERVICE_INFO, keyArg = 0, keyProps = "platform|bizExecOrderId|nodeId")
    public OpsCloudResult<OpsCloudChangeNotifySubmitResult> submitChangeFinishNotify(
            OpsCloudChangeFinishNotifyRequest request) {
        return exeChangeAsyncCheckService.starPostCheck(request);
    }

    @Override
    @OpsCloudLogAnnotation(serviceDesc = "resubmitChangeStartNotify", digestLogType = DigestLogTypeEnum.SERVICE_OPERATE_DIGEST,
            detailLogType = DetailLogTypeEnum.SERVICE_INFO, keyArg = 0, keyProps = "platform|bizExecOrderId|nodeId")
    public OpsCloudResult<OpsCloudChangeNotifySubmitResult> resubmitChangeStartNotify(OpsCloudChangeResumbitStartNotifyRequest request) {
        return exeChangeAsyncCheckService.resubmitChangeCheck(request);
    }

    @Override
    @OpsCloudLogAnnotation(serviceDesc = "finishChangeExecOrder", digestLogType = DigestLogTypeEnum.SERVICE_OPERATE_DIGEST,
            detailLogType = DetailLogTypeEnum.SERVICE_INFO, keyArg = 0, keyProps = "platform|bizExecOrderId|nodeId")
    public OpsCloudResult<OpsCloudFinishChangeExecOrderResult> finishChangeExecOrder(OpsCloudChangeExecOrderFinishRequest request) {
        return exeChangeSyncCheckService.changeFinish(request);
    }

    @Override
    @OpsCloudLogAnnotation(serviceDesc = "skipChangeCheck", digestLogType = DigestLogTypeEnum.SERVICE_OPERATE_DIGEST,
            detailLogType = DetailLogTypeEnum.SERVICE_INFO, keyArg = 0, keyProps = "platform|bizExecOrderId|nodeId")
    public OpsCloudResult<OpsCloudChangeSkipCheckResult> skipChangeCheck(OpsCloudChangeSkipCheckRequest request) {
        return exeChangeAsyncCheckService.skipChangeCheck(request);
    }

    private void generateOrderTrace(OpsCloudChangeExecOrderRequest request) {
        OpsChngTrace trace = request.getTrace();
        if (trace == null) {
            OpsCloudChangeScenarioEnum opsCloudChangeScenarioEnum = OpsCloudChangeScenarioEnum.getByCode(request.getChangeScenarioCode());
            if (opsCloudChangeScenarioEnum == null) {
                throw new IllegalArgumentException("unknown changeScenarioCode:" + request.getChangeScenarioCode());
            }
            request.setTrace(changeTraceService
                    .generateTrace(opsCloudChangeScenarioEnum, request.getBizExecOrderId()));
        }
    }

    private MetaChangeStepEntity queryMetaChangeStepEntity(OpsCloudChangeStartNotifyRequest request) {
        MetaChangeStepEntity metaChangeStepEntity = null;
        if (request instanceof OpsCloudChangeActionStartNotifyRequest) {
            metaChangeStepEntity = metaChangeSceneService.getMetaChangeStepByChangeKey(
                    ((OpsCloudChangeActionStartNotifyRequest) request).getChangeKey());
        } else if (request instanceof OpsCloudChangeExecOrderStartNotifyRequest) {
            metaChangeStepEntity = metaChangeSceneService.getOrderMetaChangeStep(request.getChangeSceneKey());
        } else if (request instanceof OpsCloudChangeExecBatchStartNotifyRequest) {
            metaChangeStepEntity = metaChangeSceneService.getBatchMetaChangeStep(request.getChangeSceneKey());
        }

        if (metaChangeStepEntity == null) {
            throw new IllegalArgumentException("illegal start notify request type:" + request.getClass()
                    + " please check request type defined in change scene entity");
        }

        return metaChangeStepEntity;
    }

    private void generateTrace(OpsCloudChangeStartNotifyRequest request, MetaChangeStepEntity metaChangeStepEntity) {
        if (request.getTrace() != null) {
            return;
        }
        OpsTraceStack traceStack = exeChangeOrderService.getOpsTraceStack(request.getPlatform(), request.getBizExecOrderId());
        if (traceStack == null) {
            throw new IllegalArgumentException(
                    "none order found for platform:" + request.getPlatform() + ", bizExecOrderId=" + request.getBizExecOrderId());
        }

        OpsChngTrace trace = traceStack.getParentTrace(metaChangeStepEntity.getStepType());
        request.setTrace(trace);
    }
}