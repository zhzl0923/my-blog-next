package indi.zhzl.myblognext.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("AdminHome")
public class HomeController {

    @GetMapping("/admin")
    public String index() {
        return "admin/index";
    }
}
