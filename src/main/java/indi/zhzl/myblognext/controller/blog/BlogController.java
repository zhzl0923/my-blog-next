package indi.zhzl.myblognext.controller.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller("blog.BlogController")
public class BlogController {

    @GetMapping("/")
    public String list() {
        return "blog/index";
    }

    @GetMapping("/blog/{id}")
    public String detail(@PathVariable String id){
        return "blog/blog_detail";
    }
}
