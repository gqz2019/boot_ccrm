package com.gqz.crm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author 20
 */
@SpringBootApplication
@MapperScan("com.gqz.crm.mapper")
@EnableTransactionManagement
public class BootCrmApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootCrmApplication.class, args);
    }
}
