package indi.zhzl.myblognext.service.impl;

import indi.zhzl.myblognext.dao.CategoryDao;
import indi.zhzl.myblognext.model.Category;
import indi.zhzl.myblognext.pojo.dto.TopLevelCategory;
import indi.zhzl.myblognext.pojo.dto.UpdateCategoryParam;
import indi.zhzl.myblognext.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Long addCategory(Long parentId, String categoryName) {
        Category category = new Category();
        category.setParentId(parentId);
        category.setCategoryName(categoryName);
        LocalDateTime now = LocalDateTime.now();
        category.setCreateTime(now);
        category.setUpdateTime(now);
        return categoryDao.insert(category);
    }

    @Override
    public List<TopLevelCategory> allCategory() {
        return categoryDao.all();
    }

    @Override
    public Integer getSubCategoryCount(Long categoryId) {
        return categoryDao.countByParentId(categoryId);
    }

    @Override
    public Integer deleteCategoryById(Long categoryId) {
        return categoryDao.deleteById(categoryId);
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        return categoryDao.getOneById(categoryId);
    }

    @Override
    public Integer updateCategory(UpdateCategoryParam updateCategoryParam) {
        Category category = new Category();
        category.setId(updateCategoryParam.getId());
        category.setCategoryName(updateCategoryParam.getCategoryName());
        category.setParentId(updateCategoryParam.getParentId());
        return categoryDao.update(category);
    }
}
