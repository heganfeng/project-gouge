package com.gouge.controller.swing.main;

import com.gouge.controller.BaseController;
import com.gouge.dao.entity.SwingUser;
import com.gouge.dao.entity.SwingUserRelation;
import com.gouge.dao.params.main.SwingNotepadParam;
import com.gouge.dao.params.main.SwingUserParam;
import com.gouge.dao.params.main.UserRelateParam;
import com.gouge.kit.josn.JsonResult;
import com.gouge.service.SwingMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Godden
 * Datetime : 2018/8/14 9:09.
 */
@Controller
@RequestMapping(value = "/apis/swing/v1/user")
public class UserSwingController extends BaseController{

    @Autowired
    private SwingMainService swingMainService;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult saveOrUpdateNotepad(@RequestBody SwingUser param, HttpServletRequest request) {
        return  new JsonResult(swingMainService.registerUser(param));
    }

    @RequestMapping(value = "/checkUserAlredy",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult checkUserAlredy(@RequestBody String userCode, HttpServletRequest request) {
        return  new JsonResult(swingMainService.checkUser(userCode));
    }

    @RequestMapping(value = "/getUserByUserCode",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult getUserByUserCode(@RequestBody String userCode, HttpServletRequest request) {
        return  new JsonResult(swingMainService.getUserByUserCode(userCode));
    }

    @RequestMapping(value = "/getUserById",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult getUserById(@RequestBody String id, HttpServletRequest request) {
        return  new JsonResult(swingMainService.getUserById(id));
    }

    @RequestMapping(value = "/getPageUserRelations",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult getPageUserRelations(@RequestBody UserRelateParam param, HttpServletRequest request) {
        return  new JsonResult(swingMainService.getPageRelations(param));
    }

    @RequestMapping(value = "/addUserRelation",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult addUserRelation(@RequestBody SwingUserRelation relation, HttpServletRequest request) {
        return  new JsonResult(swingMainService.addUserRelation(relation));
    }

    @RequestMapping(value = "/getPageByUsers",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult getPageByUsers(@RequestBody SwingUserParam param, HttpServletRequest request) {
        return  new JsonResult(swingMainService.getPageByUsers(param));
    }

    @RequestMapping(value = "/getPageCanAddRelationUsers",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult getPageCanAddRelationUsers(@RequestBody SwingUserParam param, HttpServletRequest request) {
        return  new JsonResult(swingMainService.getPageCanAddRelationUsers(param));
    }

}
