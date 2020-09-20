package com.dx.common.security;

import com.dx.sys.entity.SysUser;
import com.dx.sys.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description: com.dx.common.auth
 * suecrity的登录用户信息
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2020/9/10
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private ISysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<SysUser> sysUserList = sysUserService.loadUsersByUsername(username);

        if (sysUserList == null || sysUserList.size() == 0) {
            throw new UsernameNotFoundException("用户不存在");
        }

        return new MyUserDetails(sysUserList.get(0));

    }
}
