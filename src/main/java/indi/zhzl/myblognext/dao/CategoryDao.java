package indi.zhzl.myblognext.dao;

import indi.zhzl.myblognext.model.Category;
import indi.zhzl.myblognext.pojo.dto.TopLevelCategory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao {
    Long insert(Category category);

    List<TopLevelCategory> all();

    Integer countByParentId(@Param("categoryId") Long categoryId);

    Integer deleteById(@Param("categoryId") Long categoryId);

    Category getOneById(@Param("categoryId") Long categoryId);

    Integer update(@Param("category") Category category);
}
