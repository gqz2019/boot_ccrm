package com.gqz.crm;

import com.gqz.crm.pojo.SysUser;
import com.gqz.crm.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class BootCrmApplicationTests {
    @Autowired
    private SysUserService sysUserService;

    @Test
    void contextLoads() {
        SysUser user = sysUserService.query().eq("user_name", "小石").one();

        System.out.println(user);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String s = encoder.encode("123");
        System.out.println(s);
    }

}
