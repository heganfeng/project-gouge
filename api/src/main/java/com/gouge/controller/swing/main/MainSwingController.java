package com.gouge.controller.swing.main;

import com.gouge.dao.params.main.IdParam;
import com.gouge.kit.josn.JsonResult;
import com.gouge.service.MainService;
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
 * Datetime : 2018/8/9 22:04.
 */
@Controller
@RequestMapping(value = "/apis/swing/v1/main")
public class MainSwingController {

    @Autowired
    private SwingMainService swingMainService;

    @RequestMapping(value = "/getIcos",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult getIcos(@RequestBody IdParam idParam, HttpServletRequest request) {
        return new JsonResult(swingMainService.getIcos());
    }
}
