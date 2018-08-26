package com.gouge.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class TSysTroughPoint implements Serializable {
    private String id;

    private String title;

    private String context;

    private Integer sourcetype;

    private Integer pushbaidu;

    private Integer submitbaidu;

    private String type;

    private Integer status;

    private String isdelete;

    private Integer bad;

    private Integer good;

    private Integer readcount;

    private Integer comment;

    private String createuser;

    private String createusername;

    private Date createdate;

    private String modifyuser;

    private String modifyusername;

    private Date modifydate;

    private String syncid;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    public Integer getSourcetype() {
        return sourcetype;
    }

    public void setSourcetype(Integer sourcetype) {
        this.sourcetype = sourcetype;
    }

    public Integer getPushbaidu() {
        return pushbaidu;
    }

    public void setPushbaidu(Integer pushbaidu) {
        this.pushbaidu = pushbaidu;
    }

    public Integer getSubmitbaidu() {
        return submitbaidu;
    }

    public void setSubmitbaidu(Integer submitbaidu) {
        this.submitbaidu = submitbaidu;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(String isdelete) {
        this.isdelete = isdelete == null ? null : isdelete.trim();
    }

    public Integer getBad() {
        return bad;
    }

    public void setBad(Integer bad) {
        this.bad = bad;
    }

    public Integer getGood() {
        return good;
    }

    public void setGood(Integer good) {
        this.good = good;
    }

    public Integer getReadcount() {
        return readcount;
    }

    public void setReadcount(Integer readcount) {
        this.readcount = readcount;
    }

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser == null ? null : createuser.trim();
    }

    public String getCreateusername() {
        return createusername;
    }

    public void setCreateusername(String createusername) {
        this.createusername = createusername == null ? null : createusername.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getModifyuser() {
        return modifyuser;
    }

    public void setModifyuser(String modifyuser) {
        this.modifyuser = modifyuser == null ? null : modifyuser.trim();
    }

    public String getModifyusername() {
        return modifyusername;
    }

    public void setModifyusername(String modifyusername) {
        this.modifyusername = modifyusername == null ? null : modifyusername.trim();
    }

    public Date getModifydate() {
        return modifydate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

    public String getSyncid() {
        return syncid;
    }

    public void setSyncid(String syncid) {
        this.syncid = syncid == null ? null : syncid.trim();
    }
}