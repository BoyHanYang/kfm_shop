package com.kfm.system.service;

import com.kfm.system.model.SysMenu;
import com.kfm.system.model.SysRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SysMenuServiceTest {
    @Autowired
    private SysMenuService sysMenuService;
    @Test
    public void test(){
        assertNotNull(sysMenuService);
    }

    @Test
    public void find(){
        List<SysMenu> list = sysMenuService.list();
        System.out.println(list);
        assertEquals(1,list.size());
    }

    @Test
    public void save(){
        SysMenu sysMenu = new SysMenu();
        sysMenu.setName("测试菜单");
        sysMenu.setPermissionCode("test");
        sysMenu.setParentId(0);
        sysMenu.setType(1);
        sysMenu.setCreateTime(null);
        sysMenu.setUpdateTime(null);
        sysMenu.setUrl("http://www.baidu.com");
        sysMenuService.save(sysMenu);
        assertNotNull(sysMenu.getId());
    }
}