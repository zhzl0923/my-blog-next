package indi.zhzl.myblognext.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import indi.zhzl.myblognext.config.CaptchaConfig;
import indi.zhzl.myblognext.constants.SessionConstant;
import indi.zhzl.myblognext.exceptions.CaptchaVerificationException;
import indi.zhzl.myblognext.pojo.vo.Result;
import indi.zhzl.myblognext.utils.ResponseUtil;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class CaptchaVerificationFiler extends OncePerRequestFilter {


    private CaptchaConfig captchaConfig;


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String method = request.getMethod();
        if (uri.equals("/admin/sign_in") && method.equalsIgnoreCase("post")) {
            try {
                verificationCaptcha(request);
            } catch (CaptchaVerificationException e) {
                response.setContentType("application/json");
                Result<Object> result = ResponseUtil.fail(e.getMessage());
                OutputStream outputStream = response.getOutputStream();
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.writeValue(outputStream, result);
                outputStream.flush();
                outputStream.close();
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    private void verificationCaptcha(HttpServletRequest request) throws CaptchaVerificationException {
        String captchaCode = request.getParameter("captcha_code");
        String captchaSessionCode = (String) request.getSession().getAttribute(SessionConstant.CAPTCHA_KEY);
        if (captchaCode == null || !captchaCode.equals(captchaSessionCode)) {
            throw new CaptchaVerificationException();
        }
    }

}
