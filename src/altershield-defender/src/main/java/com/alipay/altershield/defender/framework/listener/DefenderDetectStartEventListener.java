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
 * Ant Group
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.alipay.altershield.defender.framework.listener;

import com.alipay.altershield.common.logger.Loggers;
import com.alipay.altershield.defender.framework.AbstractDefenderService;
import com.alipay.altershield.framework.common.util.logger.AlterShieldLoggerManager;
import com.alipay.altershield.framework.core.change.facade.result.AlterShieldResult;
import com.alipay.altershield.framework.core.change.model.AlterShieldChangeContent;
import com.alipay.altershield.shared.change.exe.node.entity.ExeNodeEntity;
import com.alipay.altershield.shared.change.exe.order.entity.ExeChangeOrderEntity;
import com.alipay.altershield.shared.change.exe.service.ExeChangeNodeService;
import com.alipay.altershield.shared.change.exe.service.ExeChangeOrderQueryService;
import com.alipay.altershield.shared.change.meta.model.enums.MetaChangeStepTypeEnum;
import com.alipay.altershield.shared.defender.DefenderDetectService;
import com.alipay.altershield.shared.defender.enums.DefenderVerdictEnum;
import com.alipay.altershield.shared.defender.request.DefenderDetectRequest;
import com.alipay.altershield.shared.defender.result.DefenderDetectSubmitResult;
import com.alipay.altershield.shared.schedule.enums.AlterShieldScheduleEventResultStatus;
import com.alipay.altershield.shared.schedule.event.change.ChangeNodeCheckStartEvent;
import com.alipay.altershield.shared.schedule.event.defender.DefenderDetectFinishEvent;
import com.alipay.altershield.shared.schedule.event.listener.AlterShieldSchedulerEventContext;
import com.alipay.altershield.shared.schedule.event.listener.AlterShieldSchedulerEventListener;
import com.alipay.altershield.shared.schedule.event.publish.AlterShieldSchedulerEventPublisher;
import com.alipay.altershield.shared.schedule.event.result.AlterShieldSchedulerEventExecuteResult;
import com.alipay.altershield.spi.defender.model.request.ChangeBaseInfo;
import com.alipay.altershield.spi.defender.model.request.ChangeContent;
import com.alipay.altershield.spi.defender.model.request.ChangeExecuteInfo;
import com.alipay.altershield.spi.defender.model.request.ChangeInfluenceInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Change defense post-detection start event listener
 *
 * @author yhaoxuan
 * @version DefenderDetectStartEventListener.java, v 0.1 2022年09月05日 5:38 下午 yhaoxuan
 */
@Component("defenderDetectStartEventListener")
public class DefenderDetectStartEventListener extends AbstractDefenderService
        implements AlterShieldSchedulerEventListener<ChangeNodeCheckStartEvent> {

    @Autowired
    private ExeChangeOrderQueryService exeChangeOrderQueryService;

    @Autowired
    private ExeChangeNodeService exeChangeNodeService;

    @Autowired
    private DefenderDetectService defenderDetectService;

    @Autowired
    private AlterShieldSchedulerEventPublisher alterShieldSchedulerEventPublisher;

    @Autowired
    private ExeChangeNodeService changeNodeService;

    @Override
    public AlterShieldSchedulerEventExecuteResult onEvent(AlterShieldSchedulerEventContext context, ChangeNodeCheckStartEvent event) {
        AlterShieldLoggerManager.log("info", Loggers.DEFENDER, "DefenderDetectStartEventListener", "onEvent", event);

        if (event == null || StringUtils.isBlank(event.getExeNodeId())) {
            AlterShieldLoggerManager.log("error", Loggers.DEFENDER, "DefenderDetectStartEventListener",
                    "onEvent", "fail", "event or change order id or node id can`t be empty");
            return new AlterShieldSchedulerEventExecuteResult("Parameter is illegal", AlterShieldScheduleEventResultStatus.ABANDON);
        }

        // 1.0 Query change node information
        ExeNodeEntity node = exeChangeNodeService.getNode(event.getExeNodeId());
        if (node == null) {
            AlterShieldLoggerManager.log("error", Loggers.DEFENDER, "DefenderDetectStartEventListener",
                    "onEvent", "fail", "change node does not exist", event.getExeNodeId());
            return new AlterShieldSchedulerEventExecuteResult("Change node not exist", AlterShieldScheduleEventResultStatus.ABANDON);
        }

        // 2.0 Query change order information
        ExeChangeOrderEntity changeOrder = exeChangeOrderQueryService.getChangeOrder(node.getOrderId());
        if (changeOrder == null) {
            AlterShieldLoggerManager.log("error", Loggers.DEFENDER, "DefenderDetectStartEventListener",
                    "onEvent", "fail", "change order does not exist", node.getOrderId());
            return new AlterShieldSchedulerEventExecuteResult("Change order not exist", AlterShieldScheduleEventResultStatus.ABANDON);
        }

        // 3.0 Construct request
        DefenderDetectRequest request = new DefenderDetectRequest();
        request.setChangeOrderId(node.getOrderId());
        request.setNodeId(event.getExeNodeId());
        request.setEmergency(event.isEmergency());
        request.setDefenseStage(event.getDefenseStage());
        request.setChangeSceneKey(changeOrder.getChangeSceneKey());
        request.setChangeKey(node.getChangeKey());
        request.setStepTypeEnum(event.getChangeStepType());

        // 4.0 Construct change base information
        ChangeBaseInfo changeBaseInfo = new ChangeBaseInfo();
        changeBaseInfo.setChangeTitle(changeOrder.getChangeTitle());
        changeBaseInfo.setCreator(changeOrder.getCreator());
        changeBaseInfo.setExecutor(changeOrder.getExecutor());
        changeBaseInfo.setPlatform(changeOrder.getPlatform());
        changeBaseInfo.setChangeParamJSON(changeOrder.getParamRef().readObject());

        // 4.1 Construct change content information
        ChangeContent changeContent = new ChangeContent();
        List<AlterShieldChangeContent> contents = changeOrder.getChangeContentRef().readObject();
        if (!CollectionUtils.isEmpty(contents)) {
            changeContent.setChangeContentType(contents.get(0).getContentType().getTypeName());
            changeContent.setChangeContentInstance(contents.stream().map(AlterShieldChangeContent::getInstanceName)
                    .collect(Collectors.toList()));
        }
        changeBaseInfo.setChangeContent(changeContent);
        request.setChangeBaseInfo(changeBaseInfo);

        // 4.2 Construct change execution information
        ChangeExecuteInfo changeExecuteInfo = new ChangeExecuteInfo();
        changeExecuteInfo.setChangeStartTime(node.getStartTime());
        if (node.getFinishTime() != null) {
            changeExecuteInfo.setChangeFinishTime(node.getFinishTime());
        }
        changeExecuteInfo.setOrderPhase(MetaChangeStepTypeEnum.STEP_ORDER.equals(node.getChangeStepType()));
        request.setChangeExecuteInfo(changeExecuteInfo);

        // 4.3 Construct change influence information
        ChangeInfluenceInfo changeInfluenceInfo = new ChangeInfluenceInfo();
        changeInfluenceInfo.setApps(changeOrder.getChangeAppsRef().readObject());
        changeInfluenceInfo.setExtInfo(node.getSearchExtRef().readObject());
        request.setChangeInfluenceInfo(changeInfluenceInfo);

        // 5.0 Submit defense detection
        AlterShieldResult<DefenderDetectSubmitResult> result = defenderDetectService.asyncDetect(request);
        // 5.1 Submission failed, need to try again
        if (result == null || !result.isSuccess()) {
            return new AlterShieldSchedulerEventExecuteResult("Resubmit the defense detection task", AlterShieldScheduleEventResultStatus.RETRY);
        }
        // 5.2 When the submission is successful and no defense is performed (no rules/emergency changes are matched), the defense detection end event is directly released.
        DefenderDetectSubmitResult submitResult = result.getDomain();
        if (!submitResult.isDefensed()) {
            DefenderDetectFinishEvent finishEvent = buildDefenseFinishEvent(request.getChangeOrderId(), request.getNodeId(),
                    submitResult.isDefensed(), submitResult.getMsg(), "", submitResult.getStage(),
                    DefenderVerdictEnum.PASS, event.getChangeSceneKey(), event.getChangeStepType());
            alterShieldSchedulerEventPublisher.publish(request.getChangeOrderId(), finishEvent);
            // Update node status to PASS passed
            ExeNodeEntity nodeEntity = changeNodeService.lockNodeById(request.getNodeId());
            nodeEntity.setMsg(submitResult.getMsg());
            // There may be errors in the state machine transition here, so exceptions need to be handled.
            try {
                changeNodeService.setNodeCheckFinish(nodeEntity, request.getDefenseStage(), true);
            } catch (Exception e) {
                // The state machine is abnormal, an error log is printed, and the event is not retried. The problem needs to be rectified.
                AlterShieldLoggerManager.log("error", Loggers.DEFENDER, "DefenderDetectStartEventListener",
                        "onEvent", "fail", "Exception when update node state machine: setNodeCheckFinish",
                        nodeEntity.getNodeExeId(), request.getDefenseStage());
            }
        }

        return AlterShieldSchedulerEventExecuteResult.success("Defense detection submitted successfully");
    }
}