package com.science.admin.model;

import com.science.admin.pojo.User;

import java.util.List;

public class QueryVo {
    String aa;
    String bb;
    List<User> data;

    public String getAa() {
        return aa;
    }

    public void setAa(String aa) {
        this.aa = aa;
    }

    public String getBb() {
        return bb;
    }

    public void setBb(String bb) {
        this.bb = bb;
    }

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "QueryVo{" +
                "aa='" + aa + '\'' +
                ", bb='" + bb + '\'' +
                ", data=" + data +
                '}';
    }
}
