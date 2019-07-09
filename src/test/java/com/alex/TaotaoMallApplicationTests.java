package com.alex;

import com.alex.model.UmsAdmin;
import com.alex.service.UmsAdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaotaoMallApplicationTests {

    @Autowired
    private UmsAdminService adminService;

    @Test
    public void contextLoads() {
        UmsAdmin umsAdminParam = new UmsAdmin();
        umsAdminParam.setUsername("alex");
        umsAdminParam.setPassword("alex");
        umsAdminParam.setCreateTime(new Date());
        umsAdminParam.setEmail("12333@qq.com");
        umsAdminParam.setIcon("111");
        umsAdminParam.setLoginTime(new Date());
        umsAdminParam.setNickName("alex");
        umsAdminParam.setNote("alex yan");
        umsAdminParam.setStatus(1);
        adminService.register(umsAdminParam);
    }

}
