package com.gouge.controller.swing.main;

import com.gouge.controller.BaseController;
import com.gouge.dao.params.main.IdParam;
import com.gouge.dao.params.main.SwingMusicAdvancedParam;
import com.gouge.dao.params.main.SwingNotepadParam;
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
 * Datetime : 2018/8/14 1:27.
 */
@Controller
@RequestMapping(value = "/apis/swing/v1/notepad")
public class NotepadSwingController extends BaseController{

    @Autowired
    private SwingMainService swingMainService;

    @RequestMapping(value = "/saveOrUpdateNotepad",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult saveOrUpdateNotepad(@RequestBody SwingNotepadParam param, HttpServletRequest request) {
        authorizedLogin(request);
        param.setUserId(getSwingLoginUser(request).getId());
        int result = swingMainService.saveOrUpdateNotepad(param);
        return  new JsonResult(result);
    }

    @RequestMapping(value = "/getPageNotepads",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult getPageNotepads(@RequestBody SwingNotepadParam param, HttpServletRequest request) {
        authorizedLogin(request);
        param.setUserId(getSwingLoginUser(request).getId());
        return  new JsonResult(swingMainService.getPageNotepads(param));
    }

    @RequestMapping(value = "/getNotepadById",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult getNotepadById(@RequestBody IdParam param, HttpServletRequest request) {
        authorizedLogin(request);
        return  new JsonResult(swingMainService.getNotepadById(param));
    }
}
