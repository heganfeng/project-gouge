package com.gouge.service;

import com.github.pagehelper.Page;
import com.gouge.dao.entity.*;
import com.gouge.dao.params.main.*;

import java.util.List;

/**
 * Created by Godden
 * Datetime : 2018/8/9 12:59.
 */
public interface SwingMainService {

    int insertSwingMusic(SwingMusic music);

    Page<SwingMusic> getMusics(SwingMusicAdvancedParam pageParam);

    List<SwingMusic> getMusicByUserId(SwingMusicAdvancedParam pageParam);

    List<SwingIco> getIcos();


    int saveOrUpdateNotepad(SwingNotepadParam param);

    Page<SwingNotepad> getPageNotepads(SwingNotepadParam pageParam);

    SwingNotepad getNotepadById(IdParam param);

    int registerUser(SwingUser param);

    boolean checkUser(String userCode);

    SwingUser loginOne(String userCode,String password);

    Page<SwingUserRelation> getPageRelations(UserRelateParam pageParam);

    int addUserRelation(SwingUserRelation relation);

    Page<SwingUser> getPageByUsers(SwingUserParam pageParam);

    Page<SwingUser> getPageCanAddRelationUsers(SwingUserParam pageParam);

    SwingUser getUserByUserCode(String userCode);

    SwingUser getUserById(String id);

}
