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
package com.alipay.altershield.change.meta.dal.dataobject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author jinyalong
 */
public class MetaChangeSceneParam {
    /**
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     *
     * @mbg.generated
     */
    @Deprecated
    protected boolean distinct;

    /**
     *
     * @mbg.generated
     */
    protected boolean page;

    /**
     *
     * @mbg.generated
     */
    protected int pageIndex;

    /**
     *
     * @mbg.generated
     */
    protected int pageSize;

    /**
     *
     * @mbg.generated
     */
    protected int pageStart;

    /**
     *
     * @mbg.generated
     */
    protected String distinctSql;

    /**
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbg.generated
     */
    public MetaChangeSceneParam() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * @param orderCondition
     * @param sortType
     * @return
     *
     * @mbg.generated
     */
    public MetaChangeSceneParam appendOrderByClause(OrderCondition orderCondition, SortType sortType) {
        if (null != orderByClause) {
            orderByClause = orderByClause + ", " + orderCondition.getColumnName() + " " + sortType.getValue();
        } else {
            orderByClause = orderCondition.getColumnName() + " " + sortType.getValue();
        }
        return this;
    }

    /**
     * @return
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * @param distinct
     *
     * @mbg.generated
     */
    @Deprecated
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * @return
     *
     * @mbg.generated
     */
    @Deprecated
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * @param page
     * @return
     *
     * @mbg.generated
     */
    public MetaChangeSceneParam setPage(boolean page) {
        this.page = page;
        return this;
    }

    /**
     * @return
     *
     * @mbg.generated
     */
    public boolean isPage() {
        return page;
    }

    /**
     * @return
     *
     * @mbg.generated
     */
    public int getPageIndex() {
        return pageIndex;
    }

    /**
     * @param pageSize
     * @return
     *
     * @mbg.generated
     */
    public MetaChangeSceneParam setPageSize(int pageSize) {
        this.pageSize = pageSize < 1 ? 10 : pageSize;
        this.pageIndex = pageStart < 1 ? 0 : (pageStart - 1) * this.pageSize;
        return this;
    }

    /**
     * @return
     *
     * @mbg.generated
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * @param pageStart
     * @return
     *
     * @mbg.generated
     */
    public MetaChangeSceneParam setPageStart(int pageStart) {
        this.pageStart = pageStart < 1 ? 1 : pageStart;
        this.pageIndex = (this.pageStart - 1) * this.pageSize;
        return this;
    }

    /**
     * @return
     *
     * @mbg.generated
     */
    public int getPageStart() {
        return pageStart;
    }

    /**
     * @param pageStart
     * @param pageSize
     *
     * @mbg.generated
     */
    public void setPagination(int pageStart, int pageSize) {
        this.page = true;
        this.pageSize = pageSize < 1 ? 10 : pageSize;
        this.pageIndex = pageStart < 1 ? 0 : (pageStart - 1) * this.pageSize;
    }

    /**
     * @param condition
     * @return
     *
     * @mbg.generated
     */
    public MetaChangeSceneParam appendDistinct(OrderCondition condition) {
        if (null != distinctSql){
            distinctSql = distinctSql + ", " + condition.getColumnName();
        } else {
            distinctSql = condition.getColumnName();
        }
        return this;
    }

    /**
     * @return
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * @param criteria
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * @return
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * @return
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * @return
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     *
     * @mbg.generated
     */
    protected abstract static class AbstractGeneratedCriteria {
        protected List<Criterion> criteria;

        protected AbstractGeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNull() {
            addCriterion("gmt_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("gmt_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(Date value) {
            addCriterion("gmt_modified =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Date value) {
            addCriterion("gmt_modified <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Date value) {
            addCriterion("gmt_modified >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modified >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Date value) {
            addCriterion("gmt_modified <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modified <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Date> values) {
            addCriterion("gmt_modified in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Date> values) {
            addCriterion("gmt_modified not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Date value1, Date value2) {
            addCriterion("gmt_modified between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modified not between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andTenantCodeIsNull() {
            addCriterion("tenant_code is null");
            return (Criteria) this;
        }

        public Criteria andTenantCodeIsNotNull() {
            addCriterion("tenant_code is not null");
            return (Criteria) this;
        }

        public Criteria andTenantCodeEqualTo(String value) {
            addCriterion("tenant_code =", value, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeNotEqualTo(String value) {
            addCriterion("tenant_code <>", value, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeGreaterThan(String value) {
            addCriterion("tenant_code >", value, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeGreaterThanOrEqualTo(String value) {
            addCriterion("tenant_code >=", value, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeLessThan(String value) {
            addCriterion("tenant_code <", value, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeLessThanOrEqualTo(String value) {
            addCriterion("tenant_code <=", value, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeLike(String value) {
            addCriterion("tenant_code like", value, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeNotLike(String value) {
            addCriterion("tenant_code not like", value, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeIn(List<String> values) {
            addCriterion("tenant_code in", values, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeNotIn(List<String> values) {
            addCriterion("tenant_code not in", values, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeBetween(String value1, String value2) {
            addCriterion("tenant_code between", value1, value2, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeNotBetween(String value1, String value2) {
            addCriterion("tenant_code not between", value1, value2, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andServerTenantCodeIsNull() {
            addCriterion("server_tenant_code is null");
            return (Criteria) this;
        }

        public Criteria andServerTenantCodeIsNotNull() {
            addCriterion("server_tenant_code is not null");
            return (Criteria) this;
        }

        public Criteria andServerTenantCodeEqualTo(String value) {
            addCriterion("server_tenant_code =", value, "serverTenantCode");
            return (Criteria) this;
        }

        public Criteria andServerTenantCodeNotEqualTo(String value) {
            addCriterion("server_tenant_code <>", value, "serverTenantCode");
            return (Criteria) this;
        }

        public Criteria andServerTenantCodeGreaterThan(String value) {
            addCriterion("server_tenant_code >", value, "serverTenantCode");
            return (Criteria) this;
        }

        public Criteria andServerTenantCodeGreaterThanOrEqualTo(String value) {
            addCriterion("server_tenant_code >=", value, "serverTenantCode");
            return (Criteria) this;
        }

        public Criteria andServerTenantCodeLessThan(String value) {
            addCriterion("server_tenant_code <", value, "serverTenantCode");
            return (Criteria) this;
        }

        public Criteria andServerTenantCodeLessThanOrEqualTo(String value) {
            addCriterion("server_tenant_code <=", value, "serverTenantCode");
            return (Criteria) this;
        }

        public Criteria andServerTenantCodeLike(String value) {
            addCriterion("server_tenant_code like", value, "serverTenantCode");
            return (Criteria) this;
        }

        public Criteria andServerTenantCodeNotLike(String value) {
            addCriterion("server_tenant_code not like", value, "serverTenantCode");
            return (Criteria) this;
        }

        public Criteria andServerTenantCodeIn(List<String> values) {
            addCriterion("server_tenant_code in", values, "serverTenantCode");
            return (Criteria) this;
        }

        public Criteria andServerTenantCodeNotIn(List<String> values) {
            addCriterion("server_tenant_code not in", values, "serverTenantCode");
            return (Criteria) this;
        }

        public Criteria andServerTenantCodeBetween(String value1, String value2) {
            addCriterion("server_tenant_code between", value1, value2, "serverTenantCode");
            return (Criteria) this;
        }

        public Criteria andServerTenantCodeNotBetween(String value1, String value2) {
            addCriterion("server_tenant_code not between", value1, value2, "serverTenantCode");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andChangeSceneKeyIsNull() {
            addCriterion("change_scene_key is null");
            return (Criteria) this;
        }

        public Criteria andChangeSceneKeyIsNotNull() {
            addCriterion("change_scene_key is not null");
            return (Criteria) this;
        }

        public Criteria andChangeSceneKeyEqualTo(String value) {
            addCriterion("change_scene_key =", value, "changeSceneKey");
            return (Criteria) this;
        }

        public Criteria andChangeSceneKeyNotEqualTo(String value) {
            addCriterion("change_scene_key <>", value, "changeSceneKey");
            return (Criteria) this;
        }

        public Criteria andChangeSceneKeyGreaterThan(String value) {
            addCriterion("change_scene_key >", value, "changeSceneKey");
            return (Criteria) this;
        }

        public Criteria andChangeSceneKeyGreaterThanOrEqualTo(String value) {
            addCriterion("change_scene_key >=", value, "changeSceneKey");
            return (Criteria) this;
        }

        public Criteria andChangeSceneKeyLessThan(String value) {
            addCriterion("change_scene_key <", value, "changeSceneKey");
            return (Criteria) this;
        }

        public Criteria andChangeSceneKeyLessThanOrEqualTo(String value) {
            addCriterion("change_scene_key <=", value, "changeSceneKey");
            return (Criteria) this;
        }

        public Criteria andChangeSceneKeyLike(String value) {
            addCriterion("change_scene_key like", value, "changeSceneKey");
            return (Criteria) this;
        }

        public Criteria andChangeSceneKeyNotLike(String value) {
            addCriterion("change_scene_key not like", value, "changeSceneKey");
            return (Criteria) this;
        }

        public Criteria andChangeSceneKeyIn(List<String> values) {
            addCriterion("change_scene_key in", values, "changeSceneKey");
            return (Criteria) this;
        }

        public Criteria andChangeSceneKeyNotIn(List<String> values) {
            addCriterion("change_scene_key not in", values, "changeSceneKey");
            return (Criteria) this;
        }

        public Criteria andChangeSceneKeyBetween(String value1, String value2) {
            addCriterion("change_scene_key between", value1, value2, "changeSceneKey");
            return (Criteria) this;
        }

        public Criteria andChangeSceneKeyNotBetween(String value1, String value2) {
            addCriterion("change_scene_key not between", value1, value2, "changeSceneKey");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNull() {
            addCriterion("owner is null");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNotNull() {
            addCriterion("owner is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerEqualTo(String value) {
            addCriterion("owner =", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotEqualTo(String value) {
            addCriterion("owner <>", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThan(String value) {
            addCriterion("owner >", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("owner >=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThan(String value) {
            addCriterion("owner <", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThanOrEqualTo(String value) {
            addCriterion("owner <=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLike(String value) {
            addCriterion("owner like", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotLike(String value) {
            addCriterion("owner not like", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerIn(List<String> values) {
            addCriterion("owner in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotIn(List<String> values) {
            addCriterion("owner not in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerBetween(String value1, String value2) {
            addCriterion("owner between", value1, value2, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotBetween(String value1, String value2) {
            addCriterion("owner not between", value1, value2, "owner");
            return (Criteria) this;
        }

        public Criteria andGenerationIsNull() {
            addCriterion("generation is null");
            return (Criteria) this;
        }

        public Criteria andGenerationIsNotNull() {
            addCriterion("generation is not null");
            return (Criteria) this;
        }

        public Criteria andGenerationEqualTo(String value) {
            addCriterion("generation =", value, "generation");
            return (Criteria) this;
        }

        public Criteria andGenerationNotEqualTo(String value) {
            addCriterion("generation <>", value, "generation");
            return (Criteria) this;
        }

        public Criteria andGenerationGreaterThan(String value) {
            addCriterion("generation >", value, "generation");
            return (Criteria) this;
        }

        public Criteria andGenerationGreaterThanOrEqualTo(String value) {
            addCriterion("generation >=", value, "generation");
            return (Criteria) this;
        }

        public Criteria andGenerationLessThan(String value) {
            addCriterion("generation <", value, "generation");
            return (Criteria) this;
        }

        public Criteria andGenerationLessThanOrEqualTo(String value) {
            addCriterion("generation <=", value, "generation");
            return (Criteria) this;
        }

        public Criteria andGenerationLike(String value) {
            addCriterion("generation like", value, "generation");
            return (Criteria) this;
        }

        public Criteria andGenerationNotLike(String value) {
            addCriterion("generation not like", value, "generation");
            return (Criteria) this;
        }

        public Criteria andGenerationIn(List<String> values) {
            addCriterion("generation in", values, "generation");
            return (Criteria) this;
        }

        public Criteria andGenerationNotIn(List<String> values) {
            addCriterion("generation not in", values, "generation");
            return (Criteria) this;
        }

        public Criteria andGenerationBetween(String value1, String value2) {
            addCriterion("generation between", value1, value2, "generation");
            return (Criteria) this;
        }

        public Criteria andGenerationNotBetween(String value1, String value2) {
            addCriterion("generation not between", value1, value2, "generation");
            return (Criteria) this;
        }

        public Criteria andRiskInfoIsNull() {
            addCriterion("risk_info is null");
            return (Criteria) this;
        }

        public Criteria andRiskInfoIsNotNull() {
            addCriterion("risk_info is not null");
            return (Criteria) this;
        }

        public Criteria andRiskInfoEqualTo(String value) {
            addCriterion("risk_info =", value, "riskInfo");
            return (Criteria) this;
        }

        public Criteria andRiskInfoNotEqualTo(String value) {
            addCriterion("risk_info <>", value, "riskInfo");
            return (Criteria) this;
        }

        public Criteria andRiskInfoGreaterThan(String value) {
            addCriterion("risk_info >", value, "riskInfo");
            return (Criteria) this;
        }

        public Criteria andRiskInfoGreaterThanOrEqualTo(String value) {
            addCriterion("risk_info >=", value, "riskInfo");
            return (Criteria) this;
        }

        public Criteria andRiskInfoLessThan(String value) {
            addCriterion("risk_info <", value, "riskInfo");
            return (Criteria) this;
        }

        public Criteria andRiskInfoLessThanOrEqualTo(String value) {
            addCriterion("risk_info <=", value, "riskInfo");
            return (Criteria) this;
        }

        public Criteria andRiskInfoLike(String value) {
            addCriterion("risk_info like", value, "riskInfo");
            return (Criteria) this;
        }

        public Criteria andRiskInfoNotLike(String value) {
            addCriterion("risk_info not like", value, "riskInfo");
            return (Criteria) this;
        }

        public Criteria andRiskInfoIn(List<String> values) {
            addCriterion("risk_info in", values, "riskInfo");
            return (Criteria) this;
        }

        public Criteria andRiskInfoNotIn(List<String> values) {
            addCriterion("risk_info not in", values, "riskInfo");
            return (Criteria) this;
        }

        public Criteria andRiskInfoBetween(String value1, String value2) {
            addCriterion("risk_info between", value1, value2, "riskInfo");
            return (Criteria) this;
        }

        public Criteria andRiskInfoNotBetween(String value1, String value2) {
            addCriterion("risk_info not between", value1, value2, "riskInfo");
            return (Criteria) this;
        }

        public Criteria andPlatformNameIsNull() {
            addCriterion("platform_name is null");
            return (Criteria) this;
        }

        public Criteria andPlatformNameIsNotNull() {
            addCriterion("platform_name is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformNameEqualTo(String value) {
            addCriterion("platform_name =", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameNotEqualTo(String value) {
            addCriterion("platform_name <>", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameGreaterThan(String value) {
            addCriterion("platform_name >", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameGreaterThanOrEqualTo(String value) {
            addCriterion("platform_name >=", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameLessThan(String value) {
            addCriterion("platform_name <", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameLessThanOrEqualTo(String value) {
            addCriterion("platform_name <=", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameLike(String value) {
            addCriterion("platform_name like", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameNotLike(String value) {
            addCriterion("platform_name not like", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameIn(List<String> values) {
            addCriterion("platform_name in", values, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameNotIn(List<String> values) {
            addCriterion("platform_name not in", values, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameBetween(String value1, String value2) {
            addCriterion("platform_name between", value1, value2, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameNotBetween(String value1, String value2) {
            addCriterion("platform_name not between", value1, value2, "platformName");
            return (Criteria) this;
        }

        public Criteria andScopeIsNull() {
            addCriterion("scope is null");
            return (Criteria) this;
        }

        public Criteria andScopeIsNotNull() {
            addCriterion("scope is not null");
            return (Criteria) this;
        }

        public Criteria andScopeEqualTo(String value) {
            addCriterion("scope =", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeNotEqualTo(String value) {
            addCriterion("scope <>", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeGreaterThan(String value) {
            addCriterion("scope >", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeGreaterThanOrEqualTo(String value) {
            addCriterion("scope >=", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeLessThan(String value) {
            addCriterion("scope <", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeLessThanOrEqualTo(String value) {
            addCriterion("scope <=", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeLike(String value) {
            addCriterion("scope like", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeNotLike(String value) {
            addCriterion("scope not like", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeIn(List<String> values) {
            addCriterion("scope in", values, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeNotIn(List<String> values) {
            addCriterion("scope not in", values, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeBetween(String value1, String value2) {
            addCriterion("scope between", value1, value2, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeNotBetween(String value1, String value2) {
            addCriterion("scope not between", value1, value2, "scope");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andEffectiveTargetTypeIsNull() {
            addCriterion("effective_target_type is null");
            return (Criteria) this;
        }

        public Criteria andEffectiveTargetTypeIsNotNull() {
            addCriterion("effective_target_type is not null");
            return (Criteria) this;
        }

        public Criteria andEffectiveTargetTypeEqualTo(String value) {
            addCriterion("effective_target_type =", value, "effectiveTargetType");
            return (Criteria) this;
        }

        public Criteria andEffectiveTargetTypeNotEqualTo(String value) {
            addCriterion("effective_target_type <>", value, "effectiveTargetType");
            return (Criteria) this;
        }

        public Criteria andEffectiveTargetTypeGreaterThan(String value) {
            addCriterion("effective_target_type >", value, "effectiveTargetType");
            return (Criteria) this;
        }

        public Criteria andEffectiveTargetTypeGreaterThanOrEqualTo(String value) {
            addCriterion("effective_target_type >=", value, "effectiveTargetType");
            return (Criteria) this;
        }

        public Criteria andEffectiveTargetTypeLessThan(String value) {
            addCriterion("effective_target_type <", value, "effectiveTargetType");
            return (Criteria) this;
        }

        public Criteria andEffectiveTargetTypeLessThanOrEqualTo(String value) {
            addCriterion("effective_target_type <=", value, "effectiveTargetType");
            return (Criteria) this;
        }

        public Criteria andEffectiveTargetTypeLike(String value) {
            addCriterion("effective_target_type like", value, "effectiveTargetType");
            return (Criteria) this;
        }

        public Criteria andEffectiveTargetTypeNotLike(String value) {
            addCriterion("effective_target_type not like", value, "effectiveTargetType");
            return (Criteria) this;
        }

        public Criteria andEffectiveTargetTypeIn(List<String> values) {
            addCriterion("effective_target_type in", values, "effectiveTargetType");
            return (Criteria) this;
        }

        public Criteria andEffectiveTargetTypeNotIn(List<String> values) {
            addCriterion("effective_target_type not in", values, "effectiveTargetType");
            return (Criteria) this;
        }

        public Criteria andEffectiveTargetTypeBetween(String value1, String value2) {
            addCriterion("effective_target_type between", value1, value2, "effectiveTargetType");
            return (Criteria) this;
        }

        public Criteria andEffectiveTargetTypeNotBetween(String value1, String value2) {
            addCriterion("effective_target_type not between", value1, value2, "effectiveTargetType");
            return (Criteria) this;
        }

        public Criteria andChangeContentTypeIsNull() {
            addCriterion("change_content_type is null");
            return (Criteria) this;
        }

        public Criteria andChangeContentTypeIsNotNull() {
            addCriterion("change_content_type is not null");
            return (Criteria) this;
        }

        public Criteria andChangeContentTypeEqualTo(String value) {
            addCriterion("change_content_type =", value, "changeContentType");
            return (Criteria) this;
        }

        public Criteria andChangeContentTypeNotEqualTo(String value) {
            addCriterion("change_content_type <>", value, "changeContentType");
            return (Criteria) this;
        }

        public Criteria andChangeContentTypeGreaterThan(String value) {
            addCriterion("change_content_type >", value, "changeContentType");
            return (Criteria) this;
        }

        public Criteria andChangeContentTypeGreaterThanOrEqualTo(String value) {
            addCriterion("change_content_type >=", value, "changeContentType");
            return (Criteria) this;
        }

        public Criteria andChangeContentTypeLessThan(String value) {
            addCriterion("change_content_type <", value, "changeContentType");
            return (Criteria) this;
        }

        public Criteria andChangeContentTypeLessThanOrEqualTo(String value) {
            addCriterion("change_content_type <=", value, "changeContentType");
            return (Criteria) this;
        }

        public Criteria andChangeContentTypeLike(String value) {
            addCriterion("change_content_type like", value, "changeContentType");
            return (Criteria) this;
        }

        public Criteria andChangeContentTypeNotLike(String value) {
            addCriterion("change_content_type not like", value, "changeContentType");
            return (Criteria) this;
        }

        public Criteria andChangeContentTypeIn(List<String> values) {
            addCriterion("change_content_type in", values, "changeContentType");
            return (Criteria) this;
        }

        public Criteria andChangeContentTypeNotIn(List<String> values) {
            addCriterion("change_content_type not in", values, "changeContentType");
            return (Criteria) this;
        }

        public Criteria andChangeContentTypeBetween(String value1, String value2) {
            addCriterion("change_content_type between", value1, value2, "changeContentType");
            return (Criteria) this;
        }

        public Criteria andChangeContentTypeNotBetween(String value1, String value2) {
            addCriterion("change_content_type not between", value1, value2, "changeContentType");
            return (Criteria) this;
        }

        public Criteria andChangeTargetTypeIsNull() {
            addCriterion("change_target_type is null");
            return (Criteria) this;
        }

        public Criteria andChangeTargetTypeIsNotNull() {
            addCriterion("change_target_type is not null");
            return (Criteria) this;
        }

        public Criteria andChangeTargetTypeEqualTo(String value) {
            addCriterion("change_target_type =", value, "changeTargetType");
            return (Criteria) this;
        }

        public Criteria andChangeTargetTypeNotEqualTo(String value) {
            addCriterion("change_target_type <>", value, "changeTargetType");
            return (Criteria) this;
        }

        public Criteria andChangeTargetTypeGreaterThan(String value) {
            addCriterion("change_target_type >", value, "changeTargetType");
            return (Criteria) this;
        }

        public Criteria andChangeTargetTypeGreaterThanOrEqualTo(String value) {
            addCriterion("change_target_type >=", value, "changeTargetType");
            return (Criteria) this;
        }

        public Criteria andChangeTargetTypeLessThan(String value) {
            addCriterion("change_target_type <", value, "changeTargetType");
            return (Criteria) this;
        }

        public Criteria andChangeTargetTypeLessThanOrEqualTo(String value) {
            addCriterion("change_target_type <=", value, "changeTargetType");
            return (Criteria) this;
        }

        public Criteria andChangeTargetTypeLike(String value) {
            addCriterion("change_target_type like", value, "changeTargetType");
            return (Criteria) this;
        }

        public Criteria andChangeTargetTypeNotLike(String value) {
            addCriterion("change_target_type not like", value, "changeTargetType");
            return (Criteria) this;
        }

        public Criteria andChangeTargetTypeIn(List<String> values) {
            addCriterion("change_target_type in", values, "changeTargetType");
            return (Criteria) this;
        }

        public Criteria andChangeTargetTypeNotIn(List<String> values) {
            addCriterion("change_target_type not in", values, "changeTargetType");
            return (Criteria) this;
        }

        public Criteria andChangeTargetTypeBetween(String value1, String value2) {
            addCriterion("change_target_type between", value1, value2, "changeTargetType");
            return (Criteria) this;
        }

        public Criteria andChangeTargetTypeNotBetween(String value1, String value2) {
            addCriterion("change_target_type not between", value1, value2, "changeTargetType");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andChangeEffectiveConfigJsonRefIsNull() {
            addCriterion("change_effective_config_json_ref is null");
            return (Criteria) this;
        }

        public Criteria andChangeEffectiveConfigJsonRefIsNotNull() {
            addCriterion("change_effective_config_json_ref is not null");
            return (Criteria) this;
        }

        public Criteria andChangeEffectiveConfigJsonRefEqualTo(String value) {
            addCriterion("change_effective_config_json_ref =", value, "changeEffectiveConfigJsonRef");
            return (Criteria) this;
        }

        public Criteria andChangeEffectiveConfigJsonRefNotEqualTo(String value) {
            addCriterion("change_effective_config_json_ref <>", value, "changeEffectiveConfigJsonRef");
            return (Criteria) this;
        }

        public Criteria andChangeEffectiveConfigJsonRefGreaterThan(String value) {
            addCriterion("change_effective_config_json_ref >", value, "changeEffectiveConfigJsonRef");
            return (Criteria) this;
        }

        public Criteria andChangeEffectiveConfigJsonRefGreaterThanOrEqualTo(String value) {
            addCriterion("change_effective_config_json_ref >=", value, "changeEffectiveConfigJsonRef");
            return (Criteria) this;
        }

        public Criteria andChangeEffectiveConfigJsonRefLessThan(String value) {
            addCriterion("change_effective_config_json_ref <", value, "changeEffectiveConfigJsonRef");
            return (Criteria) this;
        }

        public Criteria andChangeEffectiveConfigJsonRefLessThanOrEqualTo(String value) {
            addCriterion("change_effective_config_json_ref <=", value, "changeEffectiveConfigJsonRef");
            return (Criteria) this;
        }

        public Criteria andChangeEffectiveConfigJsonRefLike(String value) {
            addCriterion("change_effective_config_json_ref like", value, "changeEffectiveConfigJsonRef");
            return (Criteria) this;
        }

        public Criteria andChangeEffectiveConfigJsonRefNotLike(String value) {
            addCriterion("change_effective_config_json_ref not like", value, "changeEffectiveConfigJsonRef");
            return (Criteria) this;
        }

        public Criteria andChangeEffectiveConfigJsonRefIn(List<String> values) {
            addCriterion("change_effective_config_json_ref in", values, "changeEffectiveConfigJsonRef");
            return (Criteria) this;
        }

        public Criteria andChangeEffectiveConfigJsonRefNotIn(List<String> values) {
            addCriterion("change_effective_config_json_ref not in", values, "changeEffectiveConfigJsonRef");
            return (Criteria) this;
        }

        public Criteria andChangeEffectiveConfigJsonRefBetween(String value1, String value2) {
            addCriterion("change_effective_config_json_ref between", value1, value2, "changeEffectiveConfigJsonRef");
            return (Criteria) this;
        }

        public Criteria andChangeEffectiveConfigJsonRefNotBetween(String value1, String value2) {
            addCriterion("change_effective_config_json_ref not between", value1, value2, "changeEffectiveConfigJsonRef");
            return (Criteria) this;
        }

        public Criteria andCallbackConfigJsonRefIsNull() {
            addCriterion("callback_config_json_ref is null");
            return (Criteria) this;
        }

        public Criteria andCallbackConfigJsonRefIsNotNull() {
            addCriterion("callback_config_json_ref is not null");
            return (Criteria) this;
        }

        public Criteria andCallbackConfigJsonRefEqualTo(String value) {
            addCriterion("callback_config_json_ref =", value, "callbackConfigJsonRef");
            return (Criteria) this;
        }

        public Criteria andCallbackConfigJsonRefNotEqualTo(String value) {
            addCriterion("callback_config_json_ref <>", value, "callbackConfigJsonRef");
            return (Criteria) this;
        }

        public Criteria andCallbackConfigJsonRefGreaterThan(String value) {
            addCriterion("callback_config_json_ref >", value, "callbackConfigJsonRef");
            return (Criteria) this;
        }

        public Criteria andCallbackConfigJsonRefGreaterThanOrEqualTo(String value) {
            addCriterion("callback_config_json_ref >=", value, "callbackConfigJsonRef");
            return (Criteria) this;
        }

        public Criteria andCallbackConfigJsonRefLessThan(String value) {
            addCriterion("callback_config_json_ref <", value, "callbackConfigJsonRef");
            return (Criteria) this;
        }

        public Criteria andCallbackConfigJsonRefLessThanOrEqualTo(String value) {
            addCriterion("callback_config_json_ref <=", value, "callbackConfigJsonRef");
            return (Criteria) this;
        }

        public Criteria andCallbackConfigJsonRefLike(String value) {
            addCriterion("callback_config_json_ref like", value, "callbackConfigJsonRef");
            return (Criteria) this;
        }

        public Criteria andCallbackConfigJsonRefNotLike(String value) {
            addCriterion("callback_config_json_ref not like", value, "callbackConfigJsonRef");
            return (Criteria) this;
        }

        public Criteria andCallbackConfigJsonRefIn(List<String> values) {
            addCriterion("callback_config_json_ref in", values, "callbackConfigJsonRef");
            return (Criteria) this;
        }

        public Criteria andCallbackConfigJsonRefNotIn(List<String> values) {
            addCriterion("callback_config_json_ref not in", values, "callbackConfigJsonRef");
            return (Criteria) this;
        }

        public Criteria andCallbackConfigJsonRefBetween(String value1, String value2) {
            addCriterion("callback_config_json_ref between", value1, value2, "callbackConfigJsonRef");
            return (Criteria) this;
        }

        public Criteria andCallbackConfigJsonRefNotBetween(String value1, String value2) {
            addCriterion("callback_config_json_ref not between", value1, value2, "callbackConfigJsonRef");
            return (Criteria) this;
        }

        public Criteria andTagsJsonRefIsNull() {
            addCriterion("tags_json_ref is null");
            return (Criteria) this;
        }

        public Criteria andTagsJsonRefIsNotNull() {
            addCriterion("tags_json_ref is not null");
            return (Criteria) this;
        }

        public Criteria andTagsJsonRefEqualTo(String value) {
            addCriterion("tags_json_ref =", value, "tagsJsonRef");
            return (Criteria) this;
        }

        public Criteria andTagsJsonRefNotEqualTo(String value) {
            addCriterion("tags_json_ref <>", value, "tagsJsonRef");
            return (Criteria) this;
        }

        public Criteria andTagsJsonRefGreaterThan(String value) {
            addCriterion("tags_json_ref >", value, "tagsJsonRef");
            return (Criteria) this;
        }

        public Criteria andTagsJsonRefGreaterThanOrEqualTo(String value) {
            addCriterion("tags_json_ref >=", value, "tagsJsonRef");
            return (Criteria) this;
        }

        public Criteria andTagsJsonRefLessThan(String value) {
            addCriterion("tags_json_ref <", value, "tagsJsonRef");
            return (Criteria) this;
        }

        public Criteria andTagsJsonRefLessThanOrEqualTo(String value) {
            addCriterion("tags_json_ref <=", value, "tagsJsonRef");
            return (Criteria) this;
        }

        public Criteria andTagsJsonRefLike(String value) {
            addCriterion("tags_json_ref like", value, "tagsJsonRef");
            return (Criteria) this;
        }

        public Criteria andTagsJsonRefNotLike(String value) {
            addCriterion("tags_json_ref not like", value, "tagsJsonRef");
            return (Criteria) this;
        }

        public Criteria andTagsJsonRefIn(List<String> values) {
            addCriterion("tags_json_ref in", values, "tagsJsonRef");
            return (Criteria) this;
        }

        public Criteria andTagsJsonRefNotIn(List<String> values) {
            addCriterion("tags_json_ref not in", values, "tagsJsonRef");
            return (Criteria) this;
        }

        public Criteria andTagsJsonRefBetween(String value1, String value2) {
            addCriterion("tags_json_ref between", value1, value2, "tagsJsonRef");
            return (Criteria) this;
        }

        public Criteria andTagsJsonRefNotBetween(String value1, String value2) {
            addCriterion("tags_json_ref not between", value1, value2, "tagsJsonRef");
            return (Criteria) this;
        }
    }

    /**
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends AbstractGeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     *
     * @mbg.generated
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }

    /**
     *
     * @mbg.generated
     */
    public enum OrderCondition {
        /**
         *主键
         */
        ID("id"),
        /**
         *创建时间
         */
        GMTCREATE("gmt_create"),
        /**
         *修改时间
         */
        GMTMODIFIED("gmt_modified"),
        /**
         *租户
         */
        TENANTCODE("tenant_code"),
        /**
         *变更场景服务的租户 多个用逗号隔开
         */
        SERVERTENANTCODE("server_tenant_code"),
        /**
         *变更场景名字
         */
        NAME("name"),
        /**
         *场景key,一个场景的唯一标识
         */
        CHANGESCENEKEY("change_scene_key"),
        /**
         *场景负责人，多个用逗号隔开
         */
        OWNER("owner"),
        /**
         *场景代G；G0,G1,G2,G3,G4
         */
        GENERATION("generation"),
        /**
         *风险等级
         */
        RISKINFO("risk_info"),
        /**
         *平台名字，altershield_meta_platform
         */
        PLATFORMNAME("platform_name"),
        /**
         *变更场景范围。SaaS,PaaS,IaaS
         */
        SCOPE("scope"),
        /**
         *变更场景描述
         */
        DESCRIPTION("description"),
        /**
         *变更生效载体类型;多个用逗号隔开
         */
        EFFECTIVETARGETTYPE("effective_target_type"),
        /**
         *变更内容类型
         */
        CHANGECONTENTTYPE("change_content_type"),
        /**
         *变更对象类型
         */
        CHANGETARGETTYPE("change_target_type"),
        /**
         *变更场景状态 0.暂存态 1.发布状态
         */
        STATUS("status"),
        /**
         *变更生效配置详情
         */
        CHANGEEFFECTIVECONFIGJSONREF("change_effective_config_json_ref"),
        /**
         *更回调配置
         */
        CALLBACKCONFIGJSONREF("callback_config_json_ref"),
        /**
         *变更场景标签
         */
        TAGSJSONREF("tags_json_ref");

        private String columnName;

        OrderCondition(String columnName) {
            this.columnName = columnName;
        }

        public String getColumnName() {
            return columnName;
        }

        public static OrderCondition getEnumByName(String name) {
            OrderCondition[] orderConditions = OrderCondition.values();
            for (OrderCondition orderCondition : orderConditions) {
                if (orderCondition.name().equalsIgnoreCase(name)) {
                    return orderCondition;
                }
            }
            throw new RuntimeException("OrderCondition of " + name + " enum not exist");
        }

        @Override
        public String toString() {
            return columnName;
        }
    }

    /**
     *
     * @mbg.generated
     */
    public enum SortType {
        /**
         * 升序
         */
        ASC("asc"),
        /**
         * 降序
         */
        DESC("desc");

        private String value;

        SortType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static SortType getEnumByName(String name) {
            SortType[] sortTypes = SortType.values();
            for (SortType sortType : sortTypes) {
                if (sortType.name().equalsIgnoreCase(name)) {
                    return sortType;
                }
            }
            throw new RuntimeException("SortType of " + name + " enum not exist");
        }

        @Override
        public String toString() {
            return value;
        }
    }
}