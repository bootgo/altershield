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

/**
 * Enumeration of expression types supported when matching
 *
 * @author yuefan.wyf
 * @version $Id: MatchTypeEnum.java, v 0.1 2019年12月05日 下午12:08 yuefan.wyf Exp $
 */
public enum MatchTypeEnum {

    /**
     * equal
     */
    EQUAL("EQUAL"),

    /**
     * not equal
     */
    NOT_EQUAL("NOT_EQUAL"),

    /**
     * contain
     * Whether the lvalue contains the rvalue
     */
    CONTAINS("CONTAINS"),

    /**
     * cantain none
     * Whether the lvalue not contains the rvalue
     */
    CONTAINS_NONE("CONTAINS_NONE"),

    /**
     * start with
     */
    START_WITH("START_WITH"),

    /**
     * not start with
     */
    NOT_START_WITH("NOT_START_WITH"),

    /**
     * end with
     */
    END_WITH("END_WITH"),

    /**
     * not end with
     */
    NOT_END_WITH("NOT_END_WITH"),

    /**
     * less than
     */
    LESS_THAN("LESS_THAN"),

    /**
     * greater than
     */
    GREATER_THAN("GREATER_THAN"),

    /**
     * belong to
     * Determine whether the lvalue is completely included in the configuration of the rule
     */
    BELONG_TO("BELONG_TO"),
    ;

    /**
     * match type
     */
    private final String type;

    private MatchTypeEnum(String type) {
        this.type = type;
    }

    /**
     * Gets get type.
     *
     * @return the get type
     */
    public String getType() {
        return type;
    }

    /**
     * get enum value by type.
     *
     * @param type the string value
     * @return the enumeration object
     */
    public static MatchTypeEnum getByCode(String type) {
        for (MatchTypeEnum e : MatchTypeEnum.values()) {
            if (e.getType().equalsIgnoreCase(type)) {
                return e;
            }
        }

        return null;
    }
}