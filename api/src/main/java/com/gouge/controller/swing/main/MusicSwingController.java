package com.gouge.controller.swing.main;

import com.gouge.controller.BaseController;
import com.gouge.dao.params.main.IdParam;
import com.gouge.dao.params.main.SwingMusicAdvancedParam;
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
 * Datetime : 2018/8/9 17:22.
 */
@Controller
@RequestMapping(value = "/apis/swing/v1/music")
public class MusicSwingController extends BaseController{

    @Autowired
    private SwingMainService swingMainService;

    @RequestMapping(value = "/getMusics",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult getMusics(@RequestBody SwingMusicAdvancedParam param, HttpServletRequest request) {
        authorizedLogin(request);
        param.setUserId(getSwingLoginUser(request).getId());
        return new JsonResult(swingMainService.getMusics(param));
    }

    @RequestMapping(value = "/getMusicByUserId",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult getMusicByUserId(@RequestBody SwingMusicAdvancedParam param, HttpServletRequest request) {
        authorizedLogin(request);
        param.setUserId(getSwingLoginUser(request).getId());
        return new JsonResult(swingMainService.getMusicByUserId(param));
    }
}
