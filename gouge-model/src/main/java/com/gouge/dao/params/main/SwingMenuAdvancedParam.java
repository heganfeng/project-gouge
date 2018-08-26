package com.gouge.dao.params.main;

import com.gouge.dao.params.PageParam;

/**
 * Created by Godden
 * Datetime : 2018/8/8 13:19.
 */
public class SwingMenuAdvancedParam extends PageParam {
    private String menuName;
    private Integer isActive;
    private Integer isMenu;

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Integer getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(Integer isMenu) {
        this.isMenu = isMenu;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
}
