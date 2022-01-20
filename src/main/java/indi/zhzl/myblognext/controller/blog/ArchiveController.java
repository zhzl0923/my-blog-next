package indi.zhzl.myblognext.controller.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("ArchiveController")
public class ArchiveController {

    @GetMapping("/archives")
    public String list() {
        return "blog/archive";
    }
}
