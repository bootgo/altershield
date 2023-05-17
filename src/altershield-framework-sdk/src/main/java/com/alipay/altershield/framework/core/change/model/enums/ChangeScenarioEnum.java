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
package com.alipay.altershield.framework.core.change.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@ToString
public enum ChangeScenarioEnum implements Serializable {
    /**
     * Default
     */
    DEFAULT("XX"),
    /**
     * Daily Operations and Maintenance (O&M)
     */
    DAILY("00"),
    /**
     * Fault Emergency Response
     */
    EMERGE("01"),

    // ---------------- Type of Drill ----------------
    /**
     * Fault Simulation Drill Initiated
     */
    FAULT_INJECT("10"),
    /**
     * Disaster Recovery Drill
     */
    FO_PRACTICE("12"),
    /**
     * Fault Simulation Drill Initiated by Users
     */
    FAULT_MOCK_INJECT("13"),

    // ---------------- Type of Unattended ----------------
    /**
     * Unattended
     */
    UNATTENDED("30");

    private final String code;

    /**
     * @param code
     * @return
     */
    public static ChangeScenarioEnum getByCode(String code) {
        for (ChangeScenarioEnum e : ChangeScenarioEnum.values()) {
            if (e.getCode().equalsIgnoreCase(code)) {
                return e;
            }
        }
        return null;
    }
}
