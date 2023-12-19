package com.kfm.system.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kfm.system.model.SysMenu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SysMenuMapperTest {
    @Autowired
    private SysMenuMapper sysMenuMapper;
    @Test
    public void test(){
        System.out.println(sysMenuMapper);
        Assert.notNull(sysMenuMapper,"goodsMapper is null");
    }

    @Test
    public void selectAll(){
        QueryWrapper<Object> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name","张三");
        List<SysMenu> sysMenus = sysMenuMapper.selectList(null);
        System.out.println(sysMenus);
        assertEquals(1,sysMenus.size());
    }

    @Test
    public void insert(){
        SysMenu sysMenu = new SysMenu();
        sysMenu.setName("张三");
        sysMenu.setPermissionCode("123");
        sysMenu.setUrl("http://www.baidu.com");
        sysMenu.setCreateTime(null);
        sysMenu.setUpdateTime(null);
        int i = sysMenuMapper.insert(sysMenu);
        System.out.println(i);
        assertEquals(1,i);
    }
}