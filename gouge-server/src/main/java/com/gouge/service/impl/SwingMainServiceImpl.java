package com.gouge.service.impl;

import com.github.pagehelper.Page;
import com.gouge.dao.entity.*;
import com.gouge.dao.mapper.*;
import com.gouge.dao.mapperext.SwingMusicMapperExt;
import com.gouge.dao.mapperext.SwingNotepadMapperExt;
import com.gouge.dao.mapperext.SwingUserMapperExt;
import com.gouge.dao.mapperext.SwingUserRelationMapperExt;
import com.gouge.dao.params.main.*;
import com.gouge.kit.UUIDUtils;
import com.gouge.service.SwingMainService;
import com.gouge.tool.EncryptTool;
import com.gouge.util.BeanUtil;
import com.gouge.util.ObjectUtil;
import com.gouge.util.PageUtil;
import com.gouge.util.StaticUtils;
import org.apache.commons.collections.map.HashedMap;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Godden
 * Datetime : 2018/8/9 13:00.
 */
@Service
public class SwingMainServiceImpl implements SwingMainService {

    @Autowired
    private SwingMusicMapper swingMusicMapper;
    @Autowired
    private SwingMusicMapperExt swingMusicMapperExt;
    @Autowired
    private SwingIcoMapper swingIcoMapper;
    @Autowired
    private SwingNotepadMapper swingNotepadMapper;
    @Autowired
    private SwingNotepadMapperExt swingNotepadMapperExt;
    @Autowired
    private SwingUserMapper swingUserMapper;
    @Autowired
    private SwingUserMapperExt swingUserMapperExt;
    @Autowired
    private SwingUserRelationMapperExt swingUserRelationMapperExt;
    @Autowired
    private SwingUserRelationMapper swingUserRelationMapper;

    @Override
    public int insertSwingMusic(SwingMusic music) {
        return swingMusicMapper.insert(music);
    }

    @Override
    public Page<SwingMusic> getMusics(SwingMusicAdvancedParam pageParam) {
        Integer pageNo = ObjectUtil.getPageNoIntValue(pageParam, PageUtil.PAGE_INDEX_STR, PageUtil.DEFAUL_PAGE_NO);
        Integer pageSize = ObjectUtil.getIntValue(pageParam, PageUtil.PAGE_SIZE_STR, PageUtil.DEFAUL_PAGE_SIZE);
        SwingMenu menu = new SwingMenu();
        BeanUtils.copyProperties(pageParam,menu);
        Map<String,Object> map = BeanUtil.transBean2Map(pageParam);
        return swingMusicMapperExt.getPageMusic(map,new RowBounds(pageNo,pageSize));
    }

    @Override
    public List<SwingMusic> getMusicByUserId(SwingMusicAdvancedParam pageParam) {
        Map<String,Object> map = new HashedMap();
        map.put("userId",pageParam.getUserId());
        return swingMusicMapperExt.getMusicByUserId(map);
    }

    @Override
    public List<SwingIco> getIcos() {
        return swingIcoMapper.selectAll();
    }


    @Override
    public int saveOrUpdateNotepad(SwingNotepadParam param) {
        SwingNotepad swingNotepad = new SwingNotepad();
        BeanUtils.copyProperties(param,swingNotepad);
        int result = 0;
        if (param.getId() == null){
            swingNotepad.setId(UUIDUtils.generateUUID());
            swingNotepad.setCrtDate(new Date());
            result = swingNotepadMapper.insert(swingNotepad);
        }else{
            swingNotepad.setUserId(null);
            result = swingNotepadMapper.updateByPrimaryKeySelective(swingNotepad);
        }
        return result;
    }

    @Override
    public Page<SwingNotepad> getPageNotepads(SwingNotepadParam pageParam) {
        Integer pageNo = ObjectUtil.getPageNoIntValue(pageParam, PageUtil.PAGE_INDEX_STR, PageUtil.DEFAUL_PAGE_NO);
        Integer pageSize = ObjectUtil.getIntValue(pageParam, PageUtil.PAGE_SIZE_STR, PageUtil.DEFAUL_PAGE_SIZE);
        SwingNotepad notepad = new SwingNotepad();
        BeanUtils.copyProperties(pageParam,notepad);
        Map<String,Object> map = BeanUtil.transBean2Map(pageParam);
        return swingNotepadMapperExt.getPageNotepads(map,new RowBounds(pageNo,pageSize));
    }

    @Override
    public SwingNotepad getNotepadById(IdParam param) {
        SwingNotepad notepad = swingNotepadMapper.selectByPrimaryKey(param.getId());
        int click = notepad.getClick() == null ? 0 : notepad.getClick();
        SwingNotepad updateNotepad = new SwingNotepad();
        updateNotepad.setId(notepad.getId());
        updateNotepad.setUserId(notepad.getUserId());
        updateNotepad.setClick(click+1);
        swingNotepadMapper.updateByPrimaryKeySelective(updateNotepad);
        return notepad;
    }

    @Override
    public int registerUser(SwingUser param) {
        param.setId(UUIDUtils.generateUUID());
        param.setCrtDate(new Date());
        try {
           String password =  EncryptTool.getEnCode(param.getPassword(), StaticUtils.key);
            param.setPassword(password);
            param.setIsActive(0);
            param.setLevelId("0");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return swingUserMapper.insert(param);
    }

    @Override
    public boolean checkUser(String userCode) {
        SwingUser user = swingUserMapperExt.getUserByUserCode(userCode);
        if (user == null)
            return false;
        else
            return true;
    }

    @Override
    public SwingUser loginOne(String userCode, String password) {
        try {
            password = EncryptTool.getEnCode(password,StaticUtils.key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return swingUserMapperExt.loginOne(userCode,password);
    }

    @Override
    public Page<SwingUserRelation> getPageRelations(UserRelateParam pageParam) {
        Integer pageNo = ObjectUtil.getPageNoIntValue(pageParam, PageUtil.PAGE_INDEX_STR, PageUtil.DEFAUL_PAGE_NO);
        Integer pageSize = ObjectUtil.getIntValue(pageParam, PageUtil.PAGE_SIZE_STR, PageUtil.DEFAUL_PAGE_SIZE);
        SwingNotepad notepad = new SwingNotepad();
        BeanUtils.copyProperties(pageParam,notepad);
        Map<String,Object> map = BeanUtil.transBean2Map(pageParam);
        return swingUserRelationMapperExt.getPageRelations(map,new RowBounds(pageNo,pageSize));
    }

    @Override
    public int addUserRelation(SwingUserRelation relation) {
        String friend = relation.getFriendId();
        SwingUser user = swingUserMapper.selectByPrimaryKey(friend);
        relation.setId(UUIDUtils.generateUUID());
        relation.setCrtDate(new Date());
        relation.setFriendCode(user.getUserCode());
        relation.setFriendName(user.getNickName());
        relation.setFamiliarity(0);
        return swingUserRelationMapper.insert(relation);
    }


    @Override
    public Page<SwingUser> getPageByUsers(SwingUserParam pageParam) {
        Integer pageNo = ObjectUtil.getPageNoIntValue(pageParam, PageUtil.PAGE_INDEX_STR, PageUtil.DEFAUL_PAGE_NO);
        Integer pageSize = ObjectUtil.getIntValue(pageParam, PageUtil.PAGE_SIZE_STR, PageUtil.DEFAUL_PAGE_SIZE);
        SwingNotepad notepad = new SwingNotepad();
        BeanUtils.copyProperties(pageParam,notepad);
        Map<String,Object> map = BeanUtil.transBean2Map(pageParam);
        return swingUserMapperExt.getPageByUsers(map,new RowBounds(pageNo,pageSize));
    }


    @Override
    public Page<SwingUser> getPageCanAddRelationUsers(SwingUserParam pageParam) {
        Integer pageNo = ObjectUtil.getPageNoIntValue(pageParam, PageUtil.PAGE_INDEX_STR, PageUtil.DEFAUL_PAGE_NO);
        Integer pageSize = ObjectUtil.getIntValue(pageParam, PageUtil.PAGE_SIZE_STR, PageUtil.DEFAUL_PAGE_SIZE);
        SwingNotepad notepad = new SwingNotepad();
        BeanUtils.copyProperties(pageParam,notepad);
        Map<String,Object> map = BeanUtil.transBean2Map(pageParam);
        return swingUserMapperExt.getPageCanAddRelationUsers(map,new RowBounds(pageNo,pageSize));
    }


    @Override
    public SwingUser getUserByUserCode(String userCode) {
        return swingUserMapperExt.getUserByUserCode(userCode);
    }

    @Override
    public SwingUser getUserById(String id) {
        return swingUserMapper.selectByPrimaryKey(id);
    }
}
