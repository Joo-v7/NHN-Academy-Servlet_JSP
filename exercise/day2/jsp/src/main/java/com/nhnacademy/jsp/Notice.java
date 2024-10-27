package com.nhnacademy.jsp;

import java.io.Serializable;
import java.util.Date;

public class Notice implements Serializable {
    public Notice() {

    }
    public Notice(String subject, String name, long counter) {
        this.subject = subject;
        this.name = name;
        this.counter = counter;
        this.createAt = new Date();
    }

    private String subject;
    private String name;
    private Long counter;
    private Date createAt;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCounter() {
        return counter;
    }

    public void setCounter(Long counter) {
        this.counter = counter;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
