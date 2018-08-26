package com.gouge.controller.swing.main;

import com.gouge.dao.entity.SwingMenu;
import com.gouge.dao.params.PageParam;
import com.gouge.dao.params.login.LoginParam;
import com.gouge.dao.params.main.IdParam;
import com.gouge.dao.params.main.SwingMenuAdvancedParam;
import com.gouge.kit.josn.JsonResult;
import com.gouge.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Godden
 * Datetime : 2018/8/7 18:47.
 */
@Controller
@RequestMapping(value = "/apis/swing/v1/menu")
public class MenuSwingController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/getById",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult getMenus(@RequestBody IdParam idParam, HttpServletRequest request) {
        return new JsonResult(menuService.getById(idParam));
    }

    @RequestMapping(value = "/saveOrUpdateMenu",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult saveOrUpdateMenu(@RequestBody SwingMenu swingMenu, HttpServletRequest request) {
        return new JsonResult(menuService.saveOrUpdateMenu(swingMenu));
    }

    @RequestMapping(value = "/deleteSwingMenuById",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult deleteSwingMenuById(@RequestBody IdParam idParam, HttpServletRequest request) {
        return new JsonResult(menuService.deleteSwingMenuById(idParam));
    }

    @RequestMapping(value = "/getMenus",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult getMenus(@RequestBody LoginParam loginParam, HttpServletRequest request) {
        return new JsonResult(menuService.getSwingMenus());
    }

    @RequestMapping(value = "/getPageMenus",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult getPageMenus(@RequestBody SwingMenuAdvancedParam pageParam, HttpServletRequest request) {
        return new JsonResult(menuService.getPageMenus(pageParam));
    }
}
