package com.gouge.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class TSysAttachment implements Serializable {
    private String id;

    private String refid;

    private String type;

    private String path;

    private String filetype;

    private String oldname;

    private Integer imgwidth;

    private Integer imgheight;

    private String createuser;

    private Date createdate;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRefid() {
        return refid;
    }

    public void setRefid(String refid) {
        this.refid = refid == null ? null : refid.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype == null ? null : filetype.trim();
    }

    public String getOldname() {
        return oldname;
    }

    public void setOldname(String oldname) {
        this.oldname = oldname == null ? null : oldname.trim();
    }

    public Integer getImgwidth() {
        return imgwidth;
    }

    public void setImgwidth(Integer imgwidth) {
        this.imgwidth = imgwidth;
    }

    public Integer getImgheight() {
        return imgheight;
    }

    public void setImgheight(Integer imgheight) {
        this.imgheight = imgheight;
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser == null ? null : createuser.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}