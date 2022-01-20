package indi.zhzl.myblognext.controller.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller("blog.CategoryController")
public class CategoryController {

    @GetMapping("/categories")
    public String list() {
        return "blog/category";
    }

    @GetMapping("/categories/{categoryId}")
    public String detail(@PathVariable String categoryId) {
        return "blog/category_detail";
    }
}
