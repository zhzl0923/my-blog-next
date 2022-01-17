package indi.zhzl.myblognext.controller.admin;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import indi.zhzl.myblognext.constants.SessionConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private DefaultKaptcha defaultKaptcha;

    @GetMapping("/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String captchaText = defaultKaptcha.createText();
        BufferedImage image = defaultKaptcha.createImage(captchaText);
        request.getSession().setAttribute(SessionConstant.CAPTCHA_KEY, captchaText);
        OutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            response.setContentType("image/jpeg");
            response.setDateHeader("Expires", 0);
            response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
            response.addHeader("Cache-Control", "post-check=0, pre-check=0");
            response.setHeader("Pragma", "no-cache");
            ImageIO.write(image, "jpeg", outputStream);
        } catch (IOException e) {
            System.out.println("获取图片异常");
        } finally {
            if (outputStream != null) {
                outputStream.flush();
                outputStream.close();
            }

        }
    }

    @GetMapping("/login")
    public String login() {
        return "admin/login";
    }
}
