package com.gouge.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class TSysSync implements Serializable {
    private String recId;

    private String title;

    private String textContent;

    private String isSync;

    private Integer type;

    private Date createDate;

    private Date reviseDate;

    private static final long serialVersionUID = 1L;

    public String getRecId() {
        return recId;
    }

    public void setRecId(String recId) {
        this.recId = recId == null ? null : recId.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent == null ? null : textContent.trim();
    }

    public String getIsSync() {
        return isSync;
    }

    public void setIsSync(String isSync) {
        this.isSync = isSync == null ? null : isSync.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getReviseDate() {
        return reviseDate;
    }

    public void setReviseDate(Date reviseDate) {
        this.reviseDate = reviseDate;
    }
}