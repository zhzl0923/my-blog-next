package indi.zhzl.myblognext.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import indi.zhzl.myblognext.constants.SessionConstant;
import indi.zhzl.myblognext.model.AdminUser;
import indi.zhzl.myblognext.pojo.vo.Result;
import indi.zhzl.myblognext.utils.ResponseUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;

public class AuthenticationHandler implements AuthenticationSuccessHandler, AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        response.setContentType("application/json");
        Result<Object> result = ResponseUtil.fail("用户名或密码错误");
        OutputStream outputStream = response.getOutputStream();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(outputStream, result);
        outputStream.flush();
        outputStream.close();
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        HttpSession session = request.getSession();
        AdminUser adminUser = (AdminUser) authentication.getPrincipal();
        session.setAttribute(SessionConstant.LOGIN_USER_AVATAR, adminUser.getAvatar());
        session.setAttribute(SessionConstant.LOGIN_USER_NICKNAME, adminUser.getNickName());
        session.setAttribute(SessionConstant.LOGIN_USER_ID, adminUser.getId());
        session.setAttribute(SessionConstant.LOGIN_USERNAME, adminUser.getUsername());
        response.setContentType("application/json");
        Result<Object> result = ResponseUtil.success("登录成功");
        OutputStream outputStream = response.getOutputStream();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(outputStream, result);
        outputStream.flush();
        outputStream.close();
    }
}
