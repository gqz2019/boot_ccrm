package com.gqz.crm;

import com.gqz.crm.mapper.CustomerMapper;
import com.gqz.crm.pojo.Customer;
import com.gqz.crm.pojo.SysUser;
import com.gqz.crm.service.SysUserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BootCrmApplicationTests {
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    void contextLoads() {
        SysUser user = sysUserService.query().eq("user_name", "小石").one();

    }

    @Test
    void a() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = mapper.selectById(2);

    }

}
