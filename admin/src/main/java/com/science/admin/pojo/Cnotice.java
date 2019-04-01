package com.science.admin.pojo;

import java.util.Date;

public class Cnotice {
    private Long id;

    private Long dnoticeId;

    private String title;

    private String creports;

    private Date created;

    private Date updated;

    private String content;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreports() {
        return creports;
    }

    public void setCreports(String creports) {
        this.creports = creports;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}