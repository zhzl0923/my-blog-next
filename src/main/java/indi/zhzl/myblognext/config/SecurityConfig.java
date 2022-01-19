package indi.zhzl.myblognext.config;

import indi.zhzl.myblognext.filter.CaptchaVerificationFiler;
import indi.zhzl.myblognext.security.AuthenticationHandler;
import indi.zhzl.myblognext.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AdminUserService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        AuthenticationHandler handler = new AuthenticationHandler();
        http.authorizeRequests()
                .antMatchers("/admin/captcha", "/admin/login", "/admin/sign_in", "/static/**").permitAll()
                .antMatchers("/", "/tags/**", "/categories/**", "/archives/**", "/about/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .successHandler(handler)
                .failureHandler(handler)
                .loginPage("/admin/login")
                .loginProcessingUrl("/admin/sign_in")
                .and()
                .logout()
                .logoutUrl("/admin/logout")
                .logoutSuccessUrl("/admin/login")
                .and()
                .sessionManagement()
                .invalidSessionUrl("/admin/login");
        http.addFilterBefore(new CaptchaVerificationFiler(), UsernamePasswordAuthenticationFilter.class);
    }
}
