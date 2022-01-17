package indi.zhzl.myblognext.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import indi.zhzl.myblognext.constants.SessionConstant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;
import java.util.Properties;

@Configuration
public class CaptchaConfig implements Serializable {

    @Value("${captcha.font.size:'30'}")
    private String fontSize;

    @Value("${captcha.font.names:'宋体,楷体,微软雅黑'}")
    private String fontNames;

    @Value("${captcha.font.color:'red'}")
    private String fontColor;

    @Value("${captcha.image.width:'110'}")
    private String captchaImageWidth;

    @Value("${captcha.image.height:'40'}")
    private String captchaImageHeight;

    @Value("${captcha.char-length:'5'}")
    private String charLength;

    public String getFontColor() {
        return fontColor;
    }

    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    public String getCaptchaImageWidth() {
        return captchaImageWidth;
    }

    public void setCaptchaImageWidth(String captchaImageWidth) {
        this.captchaImageWidth = captchaImageWidth;
    }

    public String getCaptchaImageHeight() {
        return captchaImageHeight;
    }

    public void setCaptchaImageHeight(String captchaImageHeight) {
        this.captchaImageHeight = captchaImageHeight;
    }

    public String getFontSize() {
        return fontSize;
    }

    public void setFontSize(String fontSize) {
        this.fontSize = fontSize;
    }

    public String getCharLength() {
        return charLength;
    }

    public void setCharLength(String charLength) {
        this.charLength = charLength;
    }

    public String getFontNames() {
        return fontNames;
    }

    public void setFontNames(String fontNames) {
        this.fontNames = fontNames;
    }

    @Bean
    public DefaultKaptcha getDefaultCaptcha() {
        DefaultKaptcha dk = new DefaultKaptcha();
        Properties properties = new Properties();
        properties.setProperty("kaptcha.border", "no");
        // 字体颜色
        properties.setProperty("kaptcha.textproducer.font.color", this.getFontColor());
        // 图片宽
        properties.setProperty("kaptcha.image.width", this.getCaptchaImageWidth());
        // 图片高
        properties.setProperty("kaptcha.image.height", this.getCaptchaImageHeight());
        // 字体大小
        properties.setProperty("kaptcha.textproducer.font.size", this.getFontSize());
        // session key
        properties.setProperty("kaptcha.session.key", SessionConstant.CAPTCHA_KEY);
        // 验证码长度
        properties.setProperty("kaptcha.textproducer.char.length", this.getCharLength());
        // 字体
        properties.setProperty("kaptcha.textproducer.font.names", this.getFontNames());
        Config config = new Config(properties);
        dk.setConfig(config);

        return dk;
    }
}
