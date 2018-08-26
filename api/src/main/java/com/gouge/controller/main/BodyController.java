package com.gouge.controller.main;

import com.gouge.controller.BaseController;
import com.gouge.dao.params.login.LoginParam;
import com.gouge.dao.params.main.DetailParam;
import com.gouge.dao.params.main.IndexParam;
import com.gouge.kit.josn.JsonResult;
import com.gouge.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by grandfen on 17/8/4.
 */
@Controller
@RequestMapping(value = "/apis/v1/main")
public class BodyController extends BaseController {

    @Autowired
    private MainService mainService;

    @RequestMapping(value = "/getList",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult getMenus(@RequestBody LoginParam loginParam, HttpServletRequest request) {
        return new JsonResult(mainService.getPointByCondition());
    }

    @RequestMapping(value = "/getListPage",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult getListPage(@RequestBody IndexParam param, HttpServletRequest request) {
        return new JsonResult(mainService.getPointByPage(param));
    }

    @RequestMapping(value = "/getdetailById",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult getdetailById(@RequestBody DetailParam param, HttpServletRequest request) {
        return new JsonResult(mainService.getDetailInfo(param.getId()));
    }

}
