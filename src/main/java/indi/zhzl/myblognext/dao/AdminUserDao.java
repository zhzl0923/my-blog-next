package indi.zhzl.myblognext.dao;

import indi.zhzl.myblognext.model.AdminUser;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminUserDao {
    AdminUser getAdminUserByUsername(String username);
}
