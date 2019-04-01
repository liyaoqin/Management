package com.science.admin.model;

import com.science.admin.pojo.Project;

public class Rproject extends Project {
    String concludingstatus;
    String date;
    String reason;
    String approve;

    public String getConcludingstatus() {
        return concludingstatus;
    }

    public void setConcludingstatus(String concludingstatus) {
        this.concludingstatus = concludingstatus;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getApprove() {
        return approve;
    }

    public void setApprove(String approve) {
        this.approve = approve;
    }
}
