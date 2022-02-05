package indi.zhzl.myblognext.service;

import indi.zhzl.myblognext.model.Category;
import indi.zhzl.myblognext.pojo.dto.TopLevelCategory;
import indi.zhzl.myblognext.pojo.dto.UpdateCategoryParam;

import java.util.List;

public interface CategoryService {
    Long addCategory(Long parentId,String categoryName);

    List<TopLevelCategory> allCategory();

    Integer getSubCategoryCount(Long categoryId);

    Integer deleteCategoryById(Long categoryId);

    Category getCategoryById(Long categoryId);

    Integer updateCategory(UpdateCategoryParam updateCategoryParam);
}
