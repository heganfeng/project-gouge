package com.gouge.dao.mapper;

import com.gouge.dao.entity.TSysAttachment;

public interface TSysAttachmentMapper {
    int deleteByPrimaryKey(String id);

    int insert(TSysAttachment record);

    int insertSelective(TSysAttachment record);

    TSysAttachment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TSysAttachment record);

    int updateByPrimaryKey(TSysAttachment record);
}