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
package com.alipay.altershield.framework.core.change.facade.callback.request;

import com.alipay.altershield.framework.core.change.model.enums.ChangeCheckTypeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 回调wrapper类
 *
 * @author yuanji
 * @version : OpsCloudChangeCheckCallbackWrapperRequest.java, v 0.1 2022年03月10日 11:21 上午 yuanji Exp
 *          $
 */
@Data
@NoArgsConstructor
public class ChangeCheckCallbackWrapperRequest implements Serializable {

    private static final long serialVersionUID = -4582557020357083704L;
    private ChangeCheckTypeEnum changeCheckType;

    private ChangeCheckCallbackRequest callbackRequest;

    public ChangeCheckCallbackWrapperRequest(ChangeCheckTypeEnum changeCheckType,
            ChangeCheckCallbackRequest callbackRequest) {
        this.changeCheckType = changeCheckType;
        this.callbackRequest = callbackRequest;
    }

}
