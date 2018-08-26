package com.gouge.dao.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ApiMenu implements Serializable {
    private String id;

    private String parntId;

    private String menuName;

    private Integer isMenu;

    private Integer level;

    private String url;

    private String classStyle;

    private BigDecimal orderBy;

    private Integer isActive;

    private Date crtDate;

    private String crtPerson;

    private Date modDate;

    private String modPerson;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getParntId() {
        return parntId;
    }

    public void setParntId(String parntId) {
        this.parntId = parntId == null ? null : parntId.trim();
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public Integer getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(Integer isMenu) {
        this.isMenu = isMenu;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getClassStyle() {
        return classStyle;
    }

    public void setClassStyle(String classStyle) {
        this.classStyle = classStyle == null ? null : classStyle.trim();
    }

    public BigDecimal getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(BigDecimal orderBy) {
        this.orderBy = orderBy;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Date getCrtDate() {
        return crtDate;
    }

    public void setCrtDate(Date crtDate) {
        this.crtDate = crtDate;
    }

    public String getCrtPerson() {
        return crtPerson;
    }

    public void setCrtPerson(String crtPerson) {
        this.crtPerson = crtPerson == null ? null : crtPerson.trim();
    }

    public Date getModDate() {
        return modDate;
    }

    public void setModDate(Date modDate) {
        this.modDate = modDate;
    }

    public String getModPerson() {
        return modPerson;
    }

    public void setModPerson(String modPerson) {
        this.modPerson = modPerson == null ? null : modPerson.trim();
    }
}