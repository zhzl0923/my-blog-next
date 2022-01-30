package indi.zhzl.myblognext.service.impl;

import com.github.pagehelper.PageHelper;
import indi.zhzl.myblognext.dao.TagDao;
import indi.zhzl.myblognext.model.Tag;
import indi.zhzl.myblognext.pojo.dto.TagQueryParam;
import indi.zhzl.myblognext.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;

    @Override
    public Long addTag(String tagName) {
        Tag tag = new Tag();
        LocalDateTime now = LocalDateTime.now();
        tag.setTagName(tagName);
        tag.setCreateTime(now);
        tag.setUpdateTime(now);
        return tagDao.insert(tag);
    }

    @Override
    public List<Tag> getTagList(TagQueryParam queryParam, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return tagDao.list(queryParam);
    }

    @Override
    public Tag getTag(Long tagId) {
        return tagDao.getOneByTagId(tagId);
    }

    public Long updateTag(Long tagId, String tagName) {
        return tagDao.updateTagById(tagId, tagName);
    }

    @Override
    public Long delTag(Long tagId) {
        return tagDao.deleteTagById(tagId);
    }

}
