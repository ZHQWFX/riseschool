package com.zhq;

import com.zhq.Service.LoginuserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
class RiseschoolApplicationTests {
    @Autowired(required = false)
    DataSource dataSource;
    @Autowired
    LoginuserService loginuserService;
    @Test
    void contextLoads() {
        System.out.println(dataSource.getClass());
        System.out.println(loginuserService.queryLoginuser("admin"));
    }

}
