package com.gouge.controller;

import com.gouge.dao.params.TestParam;
import com.gouge.kit.josn.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by grandfen on 17/7/19.
 */
@Controller
@RequestMapping(value = "/apis/v1")
public class TestController {

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult test(@RequestBody TestParam cmbWithdrawReq, HttpServletRequest request) {
        System.out.println(11);
        return new JsonResult(cmbWithdrawReq.getId());
    }
}
