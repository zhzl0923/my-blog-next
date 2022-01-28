package indi.zhzl.myblognext.service.impl;

import indi.zhzl.myblognext.dao.TagDao;
import indi.zhzl.myblognext.model.Tag;
import indi.zhzl.myblognext.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
}
