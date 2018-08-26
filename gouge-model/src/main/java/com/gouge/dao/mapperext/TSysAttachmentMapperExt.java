package com.gouge.dao.mapperext;

import com.gouge.dao.entity.TSysAttachment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TSysAttachmentMapperExt {
    int updatPathToLocal(@Param("path") String path,@Param("newPath") String newPath,@Param("width") Integer width,@Param("height") Integer height);

    List<TSysAttachment> getImgByPointId(String id);
}