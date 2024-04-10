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
package com.alipay.altershield.shared.defender.enums;


import com.alipay.altershield.spi.defender.model.enums.DefenderStatusEnum;

import java.util.Arrays;
import java.util.List;

/**
 * Enumeration used to display and query defense detection status to users
 *
 * @author yhaoxuan
 * @version DefenderStatusDisplayEnum.java, v 0.1 2022年12月01日 11:01 上午 yhaoxuan
 */
public enum DefenderStatusDisplayEnum {

    /**
     * Executing
     */
    EXE("EXE", Arrays.asList(DefenderStatusEnum.EXE, DefenderStatusEnum.INIT, DefenderStatusEnum.ASYNC_CHECK,
            DefenderStatusEnum.SUSPEND)),

    /**
     * Pass
     */
    PASS("PASS", Arrays.asList(DefenderStatusEnum.PASS)),

    /**
     * Got a risk (block the change)
     */
    FAIL("FAIL", Arrays.asList(DefenderStatusEnum.FAIL)),

    /**
     * Got an exception when detecting
     */
    EXCEPTION("EXCEPTION", Arrays.asList(DefenderStatusEnum.EXCEPTION)),

    /**
     * Ignored
     */
    IGNORED("IGNORED", Arrays.asList());
    ;

    /**
     * Status displayed to users
     */
    private final String status;

    /**
     * Corresponding backend status enumeration
     */
    private final List<DefenderStatusEnum> backgroundStatus;

    DefenderStatusDisplayEnum(String status, List<DefenderStatusEnum> backgroundStatus) {
        this.status = status;
        this.backgroundStatus = backgroundStatus;
    }

    /**
     * Getter method for property <tt>status</tt>.
     *
     * @return property value of status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Getter method for property <tt>backgroundStatus</tt>.
     *
     * @return property value of backgroundStatus
     */
    public List<DefenderStatusEnum> getBackgroundStatus() {
        return backgroundStatus;
    }

    /**
     * get enum value by status.
     *
     * @param status the status
     * @return the target enum value
     */
    public static DefenderStatusDisplayEnum getByStatus(String status) {
        DefenderStatusDisplayEnum[] var1 = values();
        int var2 = var1.length;

        for (int var3 = 0; var3 < var2; ++var3) {
            DefenderStatusDisplayEnum e = var1[var3];
            if (e.getStatus().equalsIgnoreCase(status)) {
                return e;
            }
        }

        return null;
    }
}