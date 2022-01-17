package indi.zhzl.myblognext.service;

import indi.zhzl.myblognext.dao.AdminUserDao;
import indi.zhzl.myblognext.model.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdminUserService implements UserDetailsService {

    @Autowired
    private AdminUserDao adminUserDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null || username.equals("")) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        AdminUser adminUser = adminUserDao.getAdminUserByUsername(username);
        if (adminUser == null) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }

        return adminUser;
    }
}
