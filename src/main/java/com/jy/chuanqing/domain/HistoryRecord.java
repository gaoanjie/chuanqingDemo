package com.jy.chuanqing.domain;

import java.sql.Timestamp;

/**
 * 数据表historyrecord共六个字段
 */
public class HistoryRecord {
    private Integer id;
    private String transferdirection;
    private Timestamp requesttime;
    private String sourcepath;
    private String targetpath;
    private Integer runningstatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTransferdirection() {
        return transferdirection;
    }

    public void setTransferdirection(String transferdirection) {
        this.transferdirection = transferdirection;
    }

    public Timestamp getRequesttime() {
        return requesttime;
    }

    public void setRequesttime(Timestamp requesttime) {
        this.requesttime = requesttime;
    }

    public String getSourcepath() {
        return sourcepath;
    }

    public void setSourcepath(String sourcepath) {
        this.sourcepath = sourcepath;
    }

    public String getTargetpath() {
        return targetpath;
    }

    public void setTargetpath(String targetpath) {
        this.targetpath = targetpath;
    }

    public Integer getRunningstatus() {
        return runningstatus;
    }

    public void setRunningstatus(Integer runningstatus) {
        this.runningstatus = runningstatus;
    }
}
