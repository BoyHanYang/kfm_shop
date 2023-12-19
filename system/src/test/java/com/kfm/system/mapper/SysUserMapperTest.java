package com.kfm.system.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kfm.system.model.SysMenu;
import com.kfm.system.model.SysUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SysUserMapperTest {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Test
    public void test(){
        System.out.println(sysUserMapper);
        Assert.notNull(sysUserMapper,"goodsMapper is null");
    }

    @Test
    public void selectAll(){
        QueryWrapper<Object> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name","王大锤");
        List<SysUser> sysUsers = sysUserMapper.selectList(null);
        System.out.println(sysUsers);
        assertEquals(0,sysUsers.size());
    }

    @Test
    public void insert(){
        SysUser sysUser = new SysUser();
        sysUser.setName("王大锤");
        sysUser.setPassword("123456");
        sysUser.setPhone("123456");
        int i = sysUserMapper.insert(sysUser);
        System.out.println(i);
        assertEquals(1,i);
    }
}