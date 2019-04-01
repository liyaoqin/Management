package com.science.admin.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResultExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResultExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andDnoticeIdIsNull() {
            addCriterion("dnotice_id is null");
            return (Criteria) this;
        }

        public Criteria andDnoticeIdIsNotNull() {
            addCriterion("dnotice_id is not null");
            return (Criteria) this;
        }

        public Criteria andDnoticeIdEqualTo(Long value) {
            addCriterion("dnotice_id =", value, "dnoticeId");
            return (Criteria) this;
        }

        public Criteria andDnoticeIdNotEqualTo(Long value) {
            addCriterion("dnotice_id <>", value, "dnoticeId");
            return (Criteria) this;
        }

        public Criteria andDnoticeIdGreaterThan(Long value) {
            addCriterion("dnotice_id >", value, "dnoticeId");
            return (Criteria) this;
        }

        public Criteria andDnoticeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("dnotice_id >=", value, "dnoticeId");
            return (Criteria) this;
        }

        public Criteria andDnoticeIdLessThan(Long value) {
            addCriterion("dnotice_id <", value, "dnoticeId");
            return (Criteria) this;
        }

        public Criteria andDnoticeIdLessThanOrEqualTo(Long value) {
            addCriterion("dnotice_id <=", value, "dnoticeId");
            return (Criteria) this;
        }

        public Criteria andDnoticeIdIn(List<Long> values) {
            addCriterion("dnotice_id in", values, "dnoticeId");
            return (Criteria) this;
        }

        public Criteria andDnoticeIdNotIn(List<Long> values) {
            addCriterion("dnotice_id not in", values, "dnoticeId");
            return (Criteria) this;
        }

        public Criteria andDnoticeIdBetween(Long value1, Long value2) {
            addCriterion("dnotice_id between", value1, value2, "dnoticeId");
            return (Criteria) this;
        }

        public Criteria andDnoticeIdNotBetween(Long value1, Long value2) {
            addCriterion("dnotice_id not between", value1, value2, "dnoticeId");
            return (Criteria) this;
        }

        public Criteria andProjectSnumberIsNull() {
            addCriterion("project_snumber is null");
            return (Criteria) this;
        }

        public Criteria andProjectSnumberIsNotNull() {
            addCriterion("project_snumber is not null");
            return (Criteria) this;
        }

        public Criteria andProjectSnumberEqualTo(String value) {
            addCriterion("project_snumber =", value, "projectSnumber");
            return (Criteria) this;
        }

        public Criteria andProjectSnumberNotEqualTo(String value) {
            addCriterion("project_snumber <>", value, "projectSnumber");
            return (Criteria) this;
        }

        public Criteria andProjectSnumberGreaterThan(String value) {
            addCriterion("project_snumber >", value, "projectSnumber");
            return (Criteria) this;
        }

        public Criteria andProjectSnumberGreaterThanOrEqualTo(String value) {
            addCriterion("project_snumber >=", value, "projectSnumber");
            return (Criteria) this;
        }

        public Criteria andProjectSnumberLessThan(String value) {
            addCriterion("project_snumber <", value, "projectSnumber");
            return (Criteria) this;
        }

        public Criteria andProjectSnumberLessThanOrEqualTo(String value) {
            addCriterion("project_snumber <=", value, "projectSnumber");
            return (Criteria) this;
        }

        public Criteria andProjectSnumberLike(String value) {
            addCriterion("project_snumber like", value, "projectSnumber");
            return (Criteria) this;
        }

        public Criteria andProjectSnumberNotLike(String value) {
            addCriterion("project_snumber not like", value, "projectSnumber");
            return (Criteria) this;
        }

        public Criteria andProjectSnumberIn(List<String> values) {
            addCriterion("project_snumber in", values, "projectSnumber");
            return (Criteria) this;
        }

        public Criteria andProjectSnumberNotIn(List<String> values) {
            addCriterion("project_snumber not in", values, "projectSnumber");
            return (Criteria) this;
        }

        public Criteria andProjectSnumberBetween(String value1, String value2) {
            addCriterion("project_snumber between", value1, value2, "projectSnumber");
            return (Criteria) this;
        }

        public Criteria andProjectSnumberNotBetween(String value1, String value2) {
            addCriterion("project_snumber not between", value1, value2, "projectSnumber");
            return (Criteria) this;
        }

        public Criteria andProjectTitleIsNull() {
            addCriterion("project_title is null");
            return (Criteria) this;
        }

        public Criteria andProjectTitleIsNotNull() {
            addCriterion("project_title is not null");
            return (Criteria) this;
        }

        public Criteria andProjectTitleEqualTo(String value) {
            addCriterion("project_title =", value, "projectTitle");
            return (Criteria) this;
        }

        public Criteria andProjectTitleNotEqualTo(String value) {
            addCriterion("project_title <>", value, "projectTitle");
            return (Criteria) this;
        }

        public Criteria andProjectTitleGreaterThan(String value) {
            addCriterion("project_title >", value, "projectTitle");
            return (Criteria) this;
        }

        public Criteria andProjectTitleGreaterThanOrEqualTo(String value) {
            addCriterion("project_title >=", value, "projectTitle");
            return (Criteria) this;
        }

        public Criteria andProjectTitleLessThan(String value) {
            addCriterion("project_title <", value, "projectTitle");
            return (Criteria) this;
        }

        public Criteria andProjectTitleLessThanOrEqualTo(String value) {
            addCriterion("project_title <=", value, "projectTitle");
            return (Criteria) this;
        }

        public Criteria andProjectTitleLike(String value) {
            addCriterion("project_title like", value, "projectTitle");
            return (Criteria) this;
        }

        public Criteria andProjectTitleNotLike(String value) {
            addCriterion("project_title not like", value, "projectTitle");
            return (Criteria) this;
        }

        public Criteria andProjectTitleIn(List<String> values) {
            addCriterion("project_title in", values, "projectTitle");
            return (Criteria) this;
        }

        public Criteria andProjectTitleNotIn(List<String> values) {
            addCriterion("project_title not in", values, "projectTitle");
            return (Criteria) this;
        }

        public Criteria andProjectTitleBetween(String value1, String value2) {
            addCriterion("project_title between", value1, value2, "projectTitle");
            return (Criteria) this;
        }

        public Criteria andProjectTitleNotBetween(String value1, String value2) {
            addCriterion("project_title not between", value1, value2, "projectTitle");
            return (Criteria) this;
        }

        public Criteria andCresultsIsNull() {
            addCriterion("cresults is null");
            return (Criteria) this;
        }

        public Criteria andCresultsIsNotNull() {
            addCriterion("cresults is not null");
            return (Criteria) this;
        }

        public Criteria andCresultsEqualTo(String value) {
            addCriterion("cresults =", value, "cresults");
            return (Criteria) this;
        }

        public Criteria andCresultsNotEqualTo(String value) {
            addCriterion("cresults <>", value, "cresults");
            return (Criteria) this;
        }

        public Criteria andCresultsGreaterThan(String value) {
            addCriterion("cresults >", value, "cresults");
            return (Criteria) this;
        }

        public Criteria andCresultsGreaterThanOrEqualTo(String value) {
            addCriterion("cresults >=", value, "cresults");
            return (Criteria) this;
        }

        public Criteria andCresultsLessThan(String value) {
            addCriterion("cresults <", value, "cresults");
            return (Criteria) this;
        }

        public Criteria andCresultsLessThanOrEqualTo(String value) {
            addCriterion("cresults <=", value, "cresults");
            return (Criteria) this;
        }

        public Criteria andCresultsLike(String value) {
            addCriterion("cresults like", value, "cresults");
            return (Criteria) this;
        }

        public Criteria andCresultsNotLike(String value) {
            addCriterion("cresults not like", value, "cresults");
            return (Criteria) this;
        }

        public Criteria andCresultsIn(List<String> values) {
            addCriterion("cresults in", values, "cresults");
            return (Criteria) this;
        }

        public Criteria andCresultsNotIn(List<String> values) {
            addCriterion("cresults not in", values, "cresults");
            return (Criteria) this;
        }

        public Criteria andCresultsBetween(String value1, String value2) {
            addCriterion("cresults between", value1, value2, "cresults");
            return (Criteria) this;
        }

        public Criteria andCresultsNotBetween(String value1, String value2) {
            addCriterion("cresults not between", value1, value2, "cresults");
            return (Criteria) this;
        }

        public Criteria andAuditIsNull() {
            addCriterion("audit is null");
            return (Criteria) this;
        }

        public Criteria andAuditIsNotNull() {
            addCriterion("audit is not null");
            return (Criteria) this;
        }

        public Criteria andAuditEqualTo(String value) {
            addCriterion("audit =", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditNotEqualTo(String value) {
            addCriterion("audit <>", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditGreaterThan(String value) {
            addCriterion("audit >", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditGreaterThanOrEqualTo(String value) {
            addCriterion("audit >=", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditLessThan(String value) {
            addCriterion("audit <", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditLessThanOrEqualTo(String value) {
            addCriterion("audit <=", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditLike(String value) {
            addCriterion("audit like", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditNotLike(String value) {
            addCriterion("audit not like", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditIn(List<String> values) {
            addCriterion("audit in", values, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditNotIn(List<String> values) {
            addCriterion("audit not in", values, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditBetween(String value1, String value2) {
            addCriterion("audit between", value1, value2, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditNotBetween(String value1, String value2) {
            addCriterion("audit not between", value1, value2, "audit");
            return (Criteria) this;
        }

        public Criteria andSchangeIsNull() {
            addCriterion("schange is null");
            return (Criteria) this;
        }

        public Criteria andSchangeIsNotNull() {
            addCriterion("schange is not null");
            return (Criteria) this;
        }

        public Criteria andSchangeEqualTo(Byte value) {
            addCriterion("schange =", value, "schange");
            return (Criteria) this;
        }

        public Criteria andSchangeNotEqualTo(Byte value) {
            addCriterion("schange <>", value, "schange");
            return (Criteria) this;
        }

        public Criteria andSchangeGreaterThan(Byte value) {
            addCriterion("schange >", value, "schange");
            return (Criteria) this;
        }

        public Criteria andSchangeGreaterThanOrEqualTo(Byte value) {
            addCriterion("schange >=", value, "schange");
            return (Criteria) this;
        }

        public Criteria andSchangeLessThan(Byte value) {
            addCriterion("schange <", value, "schange");
            return (Criteria) this;
        }

        public Criteria andSchangeLessThanOrEqualTo(Byte value) {
            addCriterion("schange <=", value, "schange");
            return (Criteria) this;
        }

        public Criteria andSchangeIn(List<Byte> values) {
            addCriterion("schange in", values, "schange");
            return (Criteria) this;
        }

        public Criteria andSchangeNotIn(List<Byte> values) {
            addCriterion("schange not in", values, "schange");
            return (Criteria) this;
        }

        public Criteria andSchangeBetween(Byte value1, Byte value2) {
            addCriterion("schange between", value1, value2, "schange");
            return (Criteria) this;
        }

        public Criteria andSchangeNotBetween(Byte value1, Byte value2) {
            addCriterion("schange not between", value1, value2, "schange");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Date value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Date value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Date value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Date value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Date value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Date> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Date> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Date value1, Date value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Date value1, Date value2) {
            addCriterion("created not between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNull() {
            addCriterion("updated is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNotNull() {
            addCriterion("updated is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedEqualTo(Date value) {
            addCriterion("updated =", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotEqualTo(Date value) {
            addCriterion("updated <>", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThan(Date value) {
            addCriterion("updated >", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("updated >=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThan(Date value) {
            addCriterion("updated <", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThanOrEqualTo(Date value) {
            addCriterion("updated <=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedIn(List<Date> values) {
            addCriterion("updated in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotIn(List<Date> values) {
            addCriterion("updated not in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedBetween(Date value1, Date value2) {
            addCriterion("updated between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotBetween(Date value1, Date value2) {
            addCriterion("updated not between", value1, value2, "updated");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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
}