package indi.zhzl.myblognext.service;

import indi.zhzl.myblognext.model.Tag;
import indi.zhzl.myblognext.pojo.dto.TagQueryParam;

import java.util.List;

public interface TagService {
    Long addTag(String tagName);

    List<Tag> getTagList(TagQueryParam queryParam, Integer pageNum, Integer pageSize);

    Tag getTag(Long tagId);

    Long updateTag(Long tagId, String tagName);

    Long delTag(Long tagId);
}
