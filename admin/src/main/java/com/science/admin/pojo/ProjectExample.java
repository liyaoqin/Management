package com.science.admin.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectExample() {
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

        public Criteria andSnumberIsNull() {
            addCriterion("snumber is null");
            return (Criteria) this;
        }

        public Criteria andSnumberIsNotNull() {
            addCriterion("snumber is not null");
            return (Criteria) this;
        }

        public Criteria andSnumberEqualTo(String value) {
            addCriterion("snumber =", value, "snumber");
            return (Criteria) this;
        }

        public Criteria andSnumberNotEqualTo(String value) {
            addCriterion("snumber <>", value, "snumber");
            return (Criteria) this;
        }

        public Criteria andSnumberGreaterThan(String value) {
            addCriterion("snumber >", value, "snumber");
            return (Criteria) this;
        }

        public Criteria andSnumberGreaterThanOrEqualTo(String value) {
            addCriterion("snumber >=", value, "snumber");
            return (Criteria) this;
        }

        public Criteria andSnumberLessThan(String value) {
            addCriterion("snumber <", value, "snumber");
            return (Criteria) this;
        }

        public Criteria andSnumberLessThanOrEqualTo(String value) {
            addCriterion("snumber <=", value, "snumber");
            return (Criteria) this;
        }

        public Criteria andSnumberLike(String value) {
            addCriterion("snumber like", value, "snumber");
            return (Criteria) this;
        }

        public Criteria andSnumberNotLike(String value) {
            addCriterion("snumber not like", value, "snumber");
            return (Criteria) this;
        }

        public Criteria andSnumberIn(List<String> values) {
            addCriterion("snumber in", values, "snumber");
            return (Criteria) this;
        }

        public Criteria andSnumberNotIn(List<String> values) {
            addCriterion("snumber not in", values, "snumber");
            return (Criteria) this;
        }

        public Criteria andSnumberBetween(String value1, String value2) {
            addCriterion("snumber between", value1, value2, "snumber");
            return (Criteria) this;
        }

        public Criteria andSnumberNotBetween(String value1, String value2) {
            addCriterion("snumber not between", value1, value2, "snumber");
            return (Criteria) this;
        }

        public Criteria andScategoryIsNull() {
            addCriterion("scategory is null");
            return (Criteria) this;
        }

        public Criteria andScategoryIsNotNull() {
            addCriterion("scategory is not null");
            return (Criteria) this;
        }

        public Criteria andScategoryEqualTo(String value) {
            addCriterion("scategory =", value, "scategory");
            return (Criteria) this;
        }

        public Criteria andScategoryNotEqualTo(String value) {
            addCriterion("scategory <>", value, "scategory");
            return (Criteria) this;
        }

        public Criteria andScategoryGreaterThan(String value) {
            addCriterion("scategory >", value, "scategory");
            return (Criteria) this;
        }

        public Criteria andScategoryGreaterThanOrEqualTo(String value) {
            addCriterion("scategory >=", value, "scategory");
            return (Criteria) this;
        }

        public Criteria andScategoryLessThan(String value) {
            addCriterion("scategory <", value, "scategory");
            return (Criteria) this;
        }

        public Criteria andScategoryLessThanOrEqualTo(String value) {
            addCriterion("scategory <=", value, "scategory");
            return (Criteria) this;
        }

        public Criteria andScategoryLike(String value) {
            addCriterion("scategory like", value, "scategory");
            return (Criteria) this;
        }

        public Criteria andScategoryNotLike(String value) {
            addCriterion("scategory not like", value, "scategory");
            return (Criteria) this;
        }

        public Criteria andScategoryIn(List<String> values) {
            addCriterion("scategory in", values, "scategory");
            return (Criteria) this;
        }

        public Criteria andScategoryNotIn(List<String> values) {
            addCriterion("scategory not in", values, "scategory");
            return (Criteria) this;
        }

        public Criteria andScategoryBetween(String value1, String value2) {
            addCriterion("scategory between", value1, value2, "scategory");
            return (Criteria) this;
        }

        public Criteria andScategoryNotBetween(String value1, String value2) {
            addCriterion("scategory not between", value1, value2, "scategory");
            return (Criteria) this;
        }

        public Criteria andDcategoryIsNull() {
            addCriterion("dcategory is null");
            return (Criteria) this;
        }

        public Criteria andDcategoryIsNotNull() {
            addCriterion("dcategory is not null");
            return (Criteria) this;
        }

        public Criteria andDcategoryEqualTo(String value) {
            addCriterion("dcategory =", value, "dcategory");
            return (Criteria) this;
        }

        public Criteria andDcategoryNotEqualTo(String value) {
            addCriterion("dcategory <>", value, "dcategory");
            return (Criteria) this;
        }

        public Criteria andDcategoryGreaterThan(String value) {
            addCriterion("dcategory >", value, "dcategory");
            return (Criteria) this;
        }

        public Criteria andDcategoryGreaterThanOrEqualTo(String value) {
            addCriterion("dcategory >=", value, "dcategory");
            return (Criteria) this;
        }

        public Criteria andDcategoryLessThan(String value) {
            addCriterion("dcategory <", value, "dcategory");
            return (Criteria) this;
        }

        public Criteria andDcategoryLessThanOrEqualTo(String value) {
            addCriterion("dcategory <=", value, "dcategory");
            return (Criteria) this;
        }

        public Criteria andDcategoryLike(String value) {
            addCriterion("dcategory like", value, "dcategory");
            return (Criteria) this;
        }

        public Criteria andDcategoryNotLike(String value) {
            addCriterion("dcategory not like", value, "dcategory");
            return (Criteria) this;
        }

        public Criteria andDcategoryIn(List<String> values) {
            addCriterion("dcategory in", values, "dcategory");
            return (Criteria) this;
        }

        public Criteria andDcategoryNotIn(List<String> values) {
            addCriterion("dcategory not in", values, "dcategory");
            return (Criteria) this;
        }

        public Criteria andDcategoryBetween(String value1, String value2) {
            addCriterion("dcategory between", value1, value2, "dcategory");
            return (Criteria) this;
        }

        public Criteria andDcategoryNotBetween(String value1, String value2) {
            addCriterion("dcategory not between", value1, value2, "dcategory");
            return (Criteria) this;
        }

        public Criteria andHeadIsNull() {
            addCriterion("head is null");
            return (Criteria) this;
        }

        public Criteria andHeadIsNotNull() {
            addCriterion("head is not null");
            return (Criteria) this;
        }

        public Criteria andHeadEqualTo(String value) {
            addCriterion("head =", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadNotEqualTo(String value) {
            addCriterion("head <>", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadGreaterThan(String value) {
            addCriterion("head >", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadGreaterThanOrEqualTo(String value) {
            addCriterion("head >=", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadLessThan(String value) {
            addCriterion("head <", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadLessThanOrEqualTo(String value) {
            addCriterion("head <=", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadLike(String value) {
            addCriterion("head like", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadNotLike(String value) {
            addCriterion("head not like", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadIn(List<String> values) {
            addCriterion("head in", values, "head");
            return (Criteria) this;
        }

        public Criteria andHeadNotIn(List<String> values) {
            addCriterion("head not in", values, "head");
            return (Criteria) this;
        }

        public Criteria andHeadBetween(String value1, String value2) {
            addCriterion("head between", value1, value2, "head");
            return (Criteria) this;
        }

        public Criteria andHeadNotBetween(String value1, String value2) {
            addCriterion("head not between", value1, value2, "head");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andParticipantsIsNull() {
            addCriterion("participants is null");
            return (Criteria) this;
        }

        public Criteria andParticipantsIsNotNull() {
            addCriterion("participants is not null");
            return (Criteria) this;
        }

        public Criteria andParticipantsEqualTo(String value) {
            addCriterion("participants =", value, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsNotEqualTo(String value) {
            addCriterion("participants <>", value, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsGreaterThan(String value) {
            addCriterion("participants >", value, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsGreaterThanOrEqualTo(String value) {
            addCriterion("participants >=", value, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsLessThan(String value) {
            addCriterion("participants <", value, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsLessThanOrEqualTo(String value) {
            addCriterion("participants <=", value, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsLike(String value) {
            addCriterion("participants like", value, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsNotLike(String value) {
            addCriterion("participants not like", value, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsIn(List<String> values) {
            addCriterion("participants in", values, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsNotIn(List<String> values) {
            addCriterion("participants not in", values, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsBetween(String value1, String value2) {
            addCriterion("participants between", value1, value2, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsNotBetween(String value1, String value2) {
            addCriterion("participants not between", value1, value2, "participants");
            return (Criteria) this;
        }

        public Criteria andOparticipantsIsNull() {
            addCriterion("oparticipants is null");
            return (Criteria) this;
        }

        public Criteria andOparticipantsIsNotNull() {
            addCriterion("oparticipants is not null");
            return (Criteria) this;
        }

        public Criteria andOparticipantsEqualTo(String value) {
            addCriterion("oparticipants =", value, "oparticipants");
            return (Criteria) this;
        }

        public Criteria andOparticipantsNotEqualTo(String value) {
            addCriterion("oparticipants <>", value, "oparticipants");
            return (Criteria) this;
        }

        public Criteria andOparticipantsGreaterThan(String value) {
            addCriterion("oparticipants >", value, "oparticipants");
            return (Criteria) this;
        }

        public Criteria andOparticipantsGreaterThanOrEqualTo(String value) {
            addCriterion("oparticipants >=", value, "oparticipants");
            return (Criteria) this;
        }

        public Criteria andOparticipantsLessThan(String value) {
            addCriterion("oparticipants <", value, "oparticipants");
            return (Criteria) this;
        }

        public Criteria andOparticipantsLessThanOrEqualTo(String value) {
            addCriterion("oparticipants <=", value, "oparticipants");
            return (Criteria) this;
        }

        public Criteria andOparticipantsLike(String value) {
            addCriterion("oparticipants like", value, "oparticipants");
            return (Criteria) this;
        }

        public Criteria andOparticipantsNotLike(String value) {
            addCriterion("oparticipants not like", value, "oparticipants");
            return (Criteria) this;
        }

        public Criteria andOparticipantsIn(List<String> values) {
            addCriterion("oparticipants in", values, "oparticipants");
            return (Criteria) this;
        }

        public Criteria andOparticipantsNotIn(List<String> values) {
            addCriterion("oparticipants not in", values, "oparticipants");
            return (Criteria) this;
        }

        public Criteria andOparticipantsBetween(String value1, String value2) {
            addCriterion("oparticipants between", value1, value2, "oparticipants");
            return (Criteria) this;
        }

        public Criteria andOparticipantsNotBetween(String value1, String value2) {
            addCriterion("oparticipants not between", value1, value2, "oparticipants");
            return (Criteria) this;
        }

        public Criteria andGradeIsNull() {
            addCriterion("grade is null");
            return (Criteria) this;
        }

        public Criteria andGradeIsNotNull() {
            addCriterion("grade is not null");
            return (Criteria) this;
        }

        public Criteria andGradeEqualTo(String value) {
            addCriterion("grade =", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotEqualTo(String value) {
            addCriterion("grade <>", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThan(String value) {
            addCriterion("grade >", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThanOrEqualTo(String value) {
            addCriterion("grade >=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThan(String value) {
            addCriterion("grade <", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThanOrEqualTo(String value) {
            addCriterion("grade <=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLike(String value) {
            addCriterion("grade like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotLike(String value) {
            addCriterion("grade not like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeIn(List<String> values) {
            addCriterion("grade in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotIn(List<String> values) {
            addCriterion("grade not in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeBetween(String value1, String value2) {
            addCriterion("grade between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotBetween(String value1, String value2) {
            addCriterion("grade not between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andBudgetIsNull() {
            addCriterion("budget is null");
            return (Criteria) this;
        }

        public Criteria andBudgetIsNotNull() {
            addCriterion("budget is not null");
            return (Criteria) this;
        }

        public Criteria andBudgetEqualTo(Long value) {
            addCriterion("budget =", value, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetNotEqualTo(Long value) {
            addCriterion("budget <>", value, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetGreaterThan(Long value) {
            addCriterion("budget >", value, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetGreaterThanOrEqualTo(Long value) {
            addCriterion("budget >=", value, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetLessThan(Long value) {
            addCriterion("budget <", value, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetLessThanOrEqualTo(Long value) {
            addCriterion("budget <=", value, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetIn(List<Long> values) {
            addCriterion("budget in", values, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetNotIn(List<Long> values) {
            addCriterion("budget not in", values, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetBetween(Long value1, Long value2) {
            addCriterion("budget between", value1, value2, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetNotBetween(Long value1, Long value2) {
            addCriterion("budget not between", value1, value2, "budget");
            return (Criteria) this;
        }

        public Criteria andIfconcludingIsNull() {
            addCriterion("ifconcluding is null");
            return (Criteria) this;
        }

        public Criteria andIfconcludingIsNotNull() {
            addCriterion("ifconcluding is not null");
            return (Criteria) this;
        }

        public Criteria andIfconcludingEqualTo(Byte value) {
            addCriterion("ifconcluding =", value, "ifconcluding");
            return (Criteria) this;
        }

        public Criteria andIfconcludingNotEqualTo(Byte value) {
            addCriterion("ifconcluding <>", value, "ifconcluding");
            return (Criteria) this;
        }

        public Criteria andIfconcludingGreaterThan(Byte value) {
            addCriterion("ifconcluding >", value, "ifconcluding");
            return (Criteria) this;
        }

        public Criteria andIfconcludingGreaterThanOrEqualTo(Byte value) {
            addCriterion("ifconcluding >=", value, "ifconcluding");
            return (Criteria) this;
        }

        public Criteria andIfconcludingLessThan(Byte value) {
            addCriterion("ifconcluding <", value, "ifconcluding");
            return (Criteria) this;
        }

        public Criteria andIfconcludingLessThanOrEqualTo(Byte value) {
            addCriterion("ifconcluding <=", value, "ifconcluding");
            return (Criteria) this;
        }

        public Criteria andIfconcludingIn(List<Byte> values) {
            addCriterion("ifconcluding in", values, "ifconcluding");
            return (Criteria) this;
        }

        public Criteria andIfconcludingNotIn(List<Byte> values) {
            addCriterion("ifconcluding not in", values, "ifconcluding");
            return (Criteria) this;
        }

        public Criteria andIfconcludingBetween(Byte value1, Byte value2) {
            addCriterion("ifconcluding between", value1, value2, "ifconcluding");
            return (Criteria) this;
        }

        public Criteria andIfconcludingNotBetween(Byte value1, Byte value2) {
            addCriterion("ifconcluding not between", value1, value2, "ifconcluding");
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

        public Criteria andPdeclarationIsNull() {
            addCriterion("pdeclaration is null");
            return (Criteria) this;
        }

        public Criteria andPdeclarationIsNotNull() {
            addCriterion("pdeclaration is not null");
            return (Criteria) this;
        }

        public Criteria andPdeclarationEqualTo(String value) {
            addCriterion("pdeclaration =", value, "pdeclaration");
            return (Criteria) this;
        }

        public Criteria andPdeclarationNotEqualTo(String value) {
            addCriterion("pdeclaration <>", value, "pdeclaration");
            return (Criteria) this;
        }

        public Criteria andPdeclarationGreaterThan(String value) {
            addCriterion("pdeclaration >", value, "pdeclaration");
            return (Criteria) this;
        }

        public Criteria andPdeclarationGreaterThanOrEqualTo(String value) {
            addCriterion("pdeclaration >=", value, "pdeclaration");
            return (Criteria) this;
        }

        public Criteria andPdeclarationLessThan(String value) {
            addCriterion("pdeclaration <", value, "pdeclaration");
            return (Criteria) this;
        }

        public Criteria andPdeclarationLessThanOrEqualTo(String value) {
            addCriterion("pdeclaration <=", value, "pdeclaration");
            return (Criteria) this;
        }

        public Criteria andPdeclarationLike(String value) {
            addCriterion("pdeclaration like", value, "pdeclaration");
            return (Criteria) this;
        }

        public Criteria andPdeclarationNotLike(String value) {
            addCriterion("pdeclaration not like", value, "pdeclaration");
            return (Criteria) this;
        }

        public Criteria andPdeclarationIn(List<String> values) {
            addCriterion("pdeclaration in", values, "pdeclaration");
            return (Criteria) this;
        }

        public Criteria andPdeclarationNotIn(List<String> values) {
            addCriterion("pdeclaration not in", values, "pdeclaration");
            return (Criteria) this;
        }

        public Criteria andPdeclarationBetween(String value1, String value2) {
            addCriterion("pdeclaration between", value1, value2, "pdeclaration");
            return (Criteria) this;
        }

        public Criteria andPdeclarationNotBetween(String value1, String value2) {
            addCriterion("pdeclaration not between", value1, value2, "pdeclaration");
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