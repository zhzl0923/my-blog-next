package indi.zhzl.myblognext.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("admin.BlogController")
@RequestMapping("/admin/blog")
public class BlogController {

    @GetMapping("/edit")
    public String editOrCreate() {
        return "admin/blog/edit";
    }
}
