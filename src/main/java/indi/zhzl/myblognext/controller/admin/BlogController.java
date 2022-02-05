package indi.zhzl.myblognext.controller.admin;

import indi.zhzl.myblognext.pojo.vo.Result;
import indi.zhzl.myblognext.service.UploadService;
import indi.zhzl.myblognext.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

@Controller("admin.BlogController")
@RequestMapping("/admin/blog")
public class BlogController {

    @Autowired
    private UploadService uploadService;

    @GetMapping("list")
    public String list() {
        return "admin/blog/list";
    }

    @GetMapping("add")
    public String add() {
        return "admin/blog/add";
    }

    public Result<Object> create() {
        return null;
    }

    @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
    @PostMapping("upload_image")
    @ResponseBody
    public Result<Object> fileUpload(@RequestParam("editormd-image-file") MultipartFile file) {
        try {
            String uploadUrl = uploadService.upload(file);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("url", uploadUrl);
            return ResponseUtil.success("上传成功", hashMap);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseUtil.fail("上传失败");
        }
    }
}
