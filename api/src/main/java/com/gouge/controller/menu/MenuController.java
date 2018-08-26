package com.gouge.controller.menu;

import com.gouge.controller.BaseController;
import com.gouge.dao.entity.TSysUser;
import com.gouge.dao.params.login.LoginParam;
import com.gouge.exception.ApiException;
import com.gouge.kit.josn.JsonResult;
import com.gouge.redis.RedisUtil;
import com.gouge.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by grandfen on 17/8/3.
 */
@Controller
@RequestMapping(value = "/apis/v1/menu")
public class MenuController extends BaseController{

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/getMenus",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult getMenus(@RequestBody LoginParam loginParam, HttpServletRequest request) {
        return new JsonResult(menuService.getMenus());
    }
}
