package indi.zhzl.myblognext.controller.admin;

import indi.zhzl.myblognext.model.Tag;
import indi.zhzl.myblognext.pojo.dto.TagQueryParam;
import indi.zhzl.myblognext.pojo.vo.Paginate;
import indi.zhzl.myblognext.pojo.vo.Result;
import indi.zhzl.myblognext.service.TagService;
import indi.zhzl.myblognext.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller("admin.TagController")
@RequestMapping("/admin/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("list")
    public ModelAndView list(TagQueryParam queryParam,
                             @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "page_size", defaultValue = "10") Integer pageSize) {
        List<Tag> tagList = tagService.getTagList(queryParam, pageNum, pageSize);
        Paginate<Tag> paginate = Paginate.getInstance(tagList);
        ModelAndView modelAndView = new ModelAndView("admin/tag/list");
        modelAndView.addObject("paginate", paginate);
        return modelAndView;
    }

    @GetMapping("add")
    public String add() {
        return "admin/tag/add";
    }

    @GetMapping("edit/{id}")
    public ModelAndView edit(@PathVariable Long id) {
        Tag tag = tagService.getTag(id);
        ModelAndView modelAndView = new ModelAndView("admin/tag/edit");
        modelAndView.addObject("tag", tag);
        return modelAndView;
    }

    @PostMapping("create")
    @ResponseBody
    public Result<Object> create(@RequestParam(name = "tag_name") String tagName) {
        if (tagService.addTag(tagName) > 0) {
            return ResponseUtil.success("添加成功!");
        }
        return ResponseUtil.fail("添加失败!");
    }

    @PostMapping("update")
    @ResponseBody
    public Result<Object> update(@RequestParam(name = "tag_id") Long tagId,
                                 @RequestParam(name = "tag_name") String tagName) {
        if (tagService.updateTag(tagId, tagName) > 0) {
            return ResponseUtil.success("修改成功!");
        }
        return ResponseUtil.fail("修改失败!");
    }

    @PostMapping("delete")
    @ResponseBody
    public Result<Object> delete(@RequestParam(name = "tag_id") Long tagId) {
        if (tagService.delTag(tagId) > 0) {
            return ResponseUtil.success("删除成功!");
        }
        return ResponseUtil.fail("删除失败!");
    }
}
