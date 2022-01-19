package indi.zhzl.myblognext.controller.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("blog.HomeController")
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "blog/index";
    }
}
