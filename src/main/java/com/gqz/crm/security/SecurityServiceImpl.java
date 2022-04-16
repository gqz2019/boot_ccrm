package com.gqz.crm.security;

import com.gqz.crm.pojo.SysUser;
import com.gqz.crm.service.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p></p>
 *
 * @author 20
 * @create 2022-03-26 15:38
 **/
@Component
public class SecurityServiceImpl implements UserDetailsService {
    private SysUserService sysUserService;
    private ModelAndView mav;

    @Autowired
    public SecurityServiceImpl(SysUserService sysUserService, ModelAndView mav) {
        this.sysUserService = sysUserService;
        this.mav = mav;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(username)) {
            mav.addObject("msg","违法用户名称");
            throw new RuntimeException("非法用户名称");
        }
        SysUser user = sysUserService.lambdaQuery().eq(SysUser::getUserCode, username).one();
        if (user == null) {
            mav.addObject("msg","不存在名称为："+username+"的用户");
            throw new RuntimeException("不存在这个用户");
        }

        UserDetails userDetails = User.builder()
                .username(user.getUserCode())
                .password(user.getUserPassword())
                .accountExpired(false)
                .accountLocked(false)
                .authorities(AuthorityUtils.NO_AUTHORITIES)
                .build();
        return userDetails;
    }
}
