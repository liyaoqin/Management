package com.science.admin.pojo;

import java.util.Date;

public class Project {
    private Long id;

    private Long dnoticeId;

    private Long userId;

    private String snumber;

    private String scategory;

    private String dcategory;

    private String head;

    private String title;

    private String participants;

    private String oparticipants;

    private String grade;

    private Long budget;

    private Byte ifconcluding;

    private String audit;

    private Byte schange;

    private String pdeclaration;

    private Date created;

    private Date updated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDnoticeId() {
        return dnoticeId;
    }

    public void setDnoticeId(Long dnoticeId) {
        this.dnoticeId = dnoticeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSnumber() {
        return snumber;
    }

    public void setSnumber(String snumber) {
        this.snumber = snumber;
    }

    public String getScategory() {
        return scategory;
    }

    public void setScategory(String scategory) {
        this.scategory = scategory;
    }

    public String getDcategory() {
        return dcategory;
    }

    public void setDcategory(String dcategory) {
        this.dcategory = dcategory;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public String getOparticipants() {
        return oparticipants;
    }

    public void setOparticipants(String oparticipants) {
        this.oparticipants = oparticipants;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }

    public Byte getIfconcluding() {
        return ifconcluding;
    }

    public void setIfconcluding(Byte ifconcluding) {
        this.ifconcluding = ifconcluding;
    }

    public String getAudit() {
        return audit;
    }

    public void setAudit(String audit) {
        this.audit = audit;
    }

    public Byte getSchange() {
        return schange;
    }

    public void setSchange(Byte schange) {
        this.schange = schange;
    }

    public String getPdeclaration() {
        return pdeclaration;
    }

    public void setPdeclaration(String pdeclaration) {
        this.pdeclaration = pdeclaration;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}