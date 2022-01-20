package indi.zhzl.myblognext.controller.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller("blog.TagsController")
public class TagController {

    @GetMapping("/tags")
    public String list() {
        return "blog/tag";
    }

    @GetMapping("/tags/{tagId}")
    public String detail(@PathVariable String tagId) {
        return "blog/tag_detail";
    }
}
