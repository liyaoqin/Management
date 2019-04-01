package com.science.admin.pojo;

import java.util.Date;

public class Result {
    private Long id;

    private Long userId;

    private Long dnoticeId;

    private String projectSnumber;

    private String projectTitle;

    private String cresults;

    private String audit;

    private Byte schange;

    private Date created;

    private Date updated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDnoticeId() {
        return dnoticeId;
    }

    public void setDnoticeId(Long dnoticeId) {
        this.dnoticeId = dnoticeId;
    }

    public String getProjectSnumber() {
        return projectSnumber;
    }

    public void setProjectSnumber(String projectSnumber) {
        this.projectSnumber = projectSnumber;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getCresults() {
        return cresults;
    }

    public void setCresults(String cresults) {
        this.cresults = cresults;
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