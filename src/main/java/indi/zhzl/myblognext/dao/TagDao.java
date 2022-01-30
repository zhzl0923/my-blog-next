package indi.zhzl.myblognext.dao;

import indi.zhzl.myblognext.model.Tag;
import indi.zhzl.myblognext.pojo.dto.TagQueryParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagDao {
    Long insert(Tag tag);

    List<Tag> list(@Param("queryParam") TagQueryParam queryParam);

    Tag getOneByTagId(@Param("tagId") Long tagId);

    Long updateTagById(@Param("tagId") Long tagId,@Param("tagName") String tagName);

    Long deleteTagById(@Param("tagId") Long tagId);
}
