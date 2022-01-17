package indi.zhzl.myblognext.exceptions;

import org.springframework.security.core.AuthenticationException;

public class CaptchaVerificationException extends AuthenticationException {
    public CaptchaVerificationException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public CaptchaVerificationException(String msg) {
        super(msg);
    }

    public CaptchaVerificationException() {
        super("图形验证码错误");
    }
}
