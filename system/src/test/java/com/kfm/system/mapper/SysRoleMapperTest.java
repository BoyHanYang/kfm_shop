package com.kfm.system.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kfm.system.model.SysMenu;
import com.kfm.system.model.SysRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SysRoleMapperTest {
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Test
    public void test(){
        System.out.println(sysRoleMapper);
        Assert.notNull(sysRoleMapper,"goodsMapper is null");
    }

    @Test
    public void selectAll(){
        QueryWrapper<Object> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name","管理员");
        List<SysRole> sysRoles = sysRoleMapper.selectList(null);
        System.out.println(sysRoles);
        assertEquals(0,sysRoles.size());
    }

    @Test
    public void insert(){
        SysRole sysRole = new SysRole();
        sysRole.setName("管理员");
        sysRole.setRoleCode("admin");
        int i = sysRoleMapper.insert(sysRole);
        System.out.println(i);
        assertEquals(1,i);
    }

}