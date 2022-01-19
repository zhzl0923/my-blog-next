package indi.zhzl.myblognext.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("admin.HomeController")
public class HomeController {

    @GetMapping("/admin")
    public String index() {
        return "admin/index";
    }
}
