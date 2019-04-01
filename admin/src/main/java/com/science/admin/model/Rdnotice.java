package com.science.admin.model;

import com.science.admin.pojo.Dnotice;

public class Rdnotice extends Dnotice {
    String concluding;
    String date;
    String number;
    public String getConcluding() {
        return concluding;
    }

    public void setConcluding(String concluding) {
        this.concluding = concluding;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
