package com.gouge.service;

import com.github.pagehelper.Page;
import com.gouge.dao.entity.SwingMenu;
import com.gouge.dao.params.PageParam;
import com.gouge.dao.params.main.IdParam;
import com.gouge.dao.params.main.SwingMenuAdvancedParam;
import com.gouge.dao.vo.MenuVo;
import com.gouge.dao.vo.SwingMenuVo;

import java.util.List;

/**
 * Created by grandfen on 17/8/3.
 */
public interface MenuService {

    SwingMenu getById(IdParam idParam);

    int saveOrUpdateMenu(SwingMenu menu);

    int deleteSwingMenuById(IdParam idParam);

    List<MenuVo> getMenus();

    List<SwingMenuVo> getSwingMenus();

    Page<SwingMenu> getPageMenus(SwingMenuAdvancedParam pageParam);
}
