package com.pojo;

import java.util.Date;

public class Answers {
    private Integer id;

    private String anscontent;

    private Date ansdate;

    private Integer qid;

    @Override
    public String toString() {
        return "Answers{" +
                "id=" + id +
                ", anscontent='" + anscontent + '\'' +
                ", ansdate=" + ansdate +
                ", qid=" + qid +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnscontent() {
        return anscontent;
    }

    public void setAnscontent(String anscontent) {
        this.anscontent = anscontent == null ? null : anscontent.trim();
    }

    public Date getAnsdate() {
        return ansdate;
    }

    public void setAnsdate(Date ansdate) {
        this.ansdate = ansdate;
    }

    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }
}