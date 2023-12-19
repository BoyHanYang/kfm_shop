package com.kfm.system.service;

import com.kfm.system.model.SysMenu;
import com.kfm.system.model.SysUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SysUserServiceTest {
    @Autowired
    private SysUserService sysUserService;
    @Test
    public void test(){
        assertNotNull(sysUserService);
    }

    @Test
    public void find(){
        List<SysUser> list = sysUserService.list();
        System.out.println(list);
        assertEquals(1,list.size());
    }

    @Test
    public void save(){
        SysUser sysUser = new SysUser();
        sysUser.setName("测试");
        sysUser.setPassword("123456");
        sysUser.setPhone("123456");
        sysUser.setUsername("test");
        sysUserService.save(sysUser);
        assertNotNull(sysUser.getId());
    }
}