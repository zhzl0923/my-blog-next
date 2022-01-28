package indi.zhzl.myblognext.controller.admin;

import indi.zhzl.myblognext.pojo.vo.Result;
import indi.zhzl.myblognext.service.TagService;
import indi.zhzl.myblognext.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller("admin.TagController")
@RequestMapping("/admin/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("list")
    public String list() {
        return "admin/tag/list";
    }

    @GetMapping("add")
    public String add() {
        return "admin/tag/add";
    }

    @GetMapping("edit")
    public String edit() {
        return "admin/tag/edit";
    }

    @PostMapping("create")
    @ResponseBody
    public Result<Object> create(@RequestParam(name = "tag_name") String tagName) {
        if (tagService.addTag(tagName) > 0) {
            return ResponseUtil.success("添加成功!");
        }
        return ResponseUtil.fail("添加失败!");
    }

}
