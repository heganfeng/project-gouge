package com.gouge.dao.vo;

import com.gouge.dao.entity.ApiMenu;

import java.util.List;

/**
 * Created by grandfen on 17/8/3.
 */
public class MenuVo {

    private String id;

    private String menuName;

    private Integer isMenu;

    private Integer level;

    private String url;

    private String classStyle;

    private List<ApiMenu> menus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
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
        this.url = url;
    }

    public String getClassStyle() {
        return classStyle;
    }

    public void setClassStyle(String classStyle) {
        this.classStyle = classStyle;
    }

    public List<ApiMenu> getMenus() {
        return menus;
    }

    public void setMenus(List<ApiMenu> menus) {
        this.menus = menus;
    }
}
