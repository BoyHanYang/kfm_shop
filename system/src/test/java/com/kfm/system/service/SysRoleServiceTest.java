package com.kfm.system.service;

import com.kfm.system.model.SysRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SysRoleServiceTest {
    @Autowired
    private SysRoleService sysRoleService;
    @Test
    public void test(){
        assertNotNull(sysRoleService);
    }

    @Test
    public void find(){
        List<SysRole> list = sysRoleService.list();
        System.out.println(list);
        assertEquals(1,list.size());
    }

    @Test
    public void save(){
        SysRole sysRole = new SysRole();
        sysRole.setName("测试角色");
        sysRole.setRoleCode("test");
        sysRole.setCreateTime(null);
        sysRole.setUpdateTime(null);
        sysRoleService.save(sysRole);
        assertNotNull(sysRole.getId());
    }
}