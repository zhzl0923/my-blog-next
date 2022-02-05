package indi.zhzl.myblognext.controller.admin;

import com.fasterxml.jackson.core.JsonProcessingException;
import indi.zhzl.myblognext.annotation.ParameterConvert;
import indi.zhzl.myblognext.model.Category;
import indi.zhzl.myblognext.pojo.dto.TopLevelCategory;
import indi.zhzl.myblognext.pojo.dto.UpdateCategoryParam;
import indi.zhzl.myblognext.pojo.vo.Result;
import indi.zhzl.myblognext.service.CategoryService;
import indi.zhzl.myblognext.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("list")
    public ModelAndView list() throws JsonProcessingException {
        List<TopLevelCategory> categories = categoryService.allCategory();
        ModelAndView modelAndView = new ModelAndView("admin/category/list");
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }

    @GetMapping("add")
    public ModelAndView add() {
        List<TopLevelCategory> categories = categoryService.allCategory();
        ModelAndView modelAndView = new ModelAndView("admin/category/add");
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }

    @GetMapping("edit/{id}")
    public ModelAndView edit(@PathVariable Long id) {
        Category categoryInfo = categoryService.getCategoryById(id);
        List<TopLevelCategory> categories = categoryService.allCategory();
        ModelAndView modelAndView = new ModelAndView("admin/category/edit");
        modelAndView.addObject("categoryInfo", categoryInfo);
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }

    @PostMapping("create")
    @ResponseBody
    public Result<Object> create(@RequestParam(name = "parent_id") Long parentId, @RequestParam(name = "category_name") String categoryName) {
        if (categoryService.addCategory(parentId, categoryName) > 0) {
            return ResponseUtil.success("添加成功!");
        }
        return ResponseUtil.fail("添加失败!");
    }

    @PostMapping("delete")
    @ResponseBody
    public Result<Object> delete(@RequestParam("category_id") Long categoryId) {
        Integer subCategoryCount = categoryService.getSubCategoryCount(categoryId);
        if (subCategoryCount > 0) {
            return ResponseUtil.fail("请先删除子分类");
        }
        if (categoryService.deleteCategoryById(categoryId) > 0) {
            return ResponseUtil.success("删除成功");
        }
        return ResponseUtil.fail("删除失败");
    }

    @PostMapping("update")
    @ResponseBody
    public Result<Object> update(@ParameterConvert UpdateCategoryParam param) {
        if (categoryService.updateCategory(param) > 0) {
            return ResponseUtil.success("修改成功");
        }
        return ResponseUtil.fail("修改失败");
    }
}
