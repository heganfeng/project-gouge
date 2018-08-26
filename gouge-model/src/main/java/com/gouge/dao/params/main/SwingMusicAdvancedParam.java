package com.gouge.dao.params.main;

import com.gouge.dao.params.PageParam;

/**
 * Created by Godden
 * Datetime : 2018/8/8 13:19.
 */
public class SwingMusicAdvancedParam extends PageParam {

    private String musicName;

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }
}
