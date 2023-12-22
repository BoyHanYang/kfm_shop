package com.kfm.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.kfm.system.model.SysUser;
import com.kfm.system.service.SysUserService;
import com.kfm.system.util.Result;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * @Author yangbohan
 * @Date 2023/12/19 23:09
 */
@RestController
@RequestMapping("/systemUser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/login")
    @ApiOperation(value = "用户登录", notes = "用户登录")
    public Result login(@RequestBody SysUser sysUser) {
        /*QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",sysUser.getUsername());
        queryWrapper.eq("password",sysUser.getPassword());
        SysUser user = sysUserService.getOne(queryWrapper);
        if (ObjectUtils.isEmpty(user)){
            return Result.error("用户名或密码错误");
        }
        String token = new Random().nextLong()+"";
        redisTemplate.opsForValue().set(token,user);*/
        String token = sysUserService.login(sysUser);
        return Result.ok("登录成功").put("token",token);
    }
    @GetMapping
    @ApiOperation(value = "获取用户信息", notes = "获取用户信息")
    public Result getUser(@ApiParam(name = "goods",value = "商品信息")SysUser sysUser) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        if (!ObjectUtils.isEmpty(sysUser.getName())){
            queryWrapper.like("name",sysUser.getName());
        }
        if (!ObjectUtils.isEmpty(sysUser.getName())){
            queryWrapper.eq("status",sysUser.getName());
        }
        PageHelper.startPage(sysUser.getPage(),sysUser.getSize());
        return Result.ok(sysUserService.list(queryWrapper));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取用户信息", notes = "根据id获取用户信息")
    public Result getGoodsById(@ApiParam(name = "id", value = "用户id", required = true) @PathVariable Integer id) {
        return Result.ok(sysUserService.getById(id));
    }


    @PostMapping
    @ApiOperation(value = "根据id修改用户信息", notes = "根据id修改用户信息")
    public Result updateGoodsById(@ApiParam(name = "sysUser", value = "用户信息", required = true)@RequestBody SysUser sysUser) {
        return Result.ok(sysUserService.updateById(sysUser));
    }


    @PutMapping
    @ApiOperation(value = "新增用户信息", notes = "新增用户信息")
    public Result addGoods(@ApiParam(name = "sysUser", value = "用户信息", required = true)@RequestBody SysUser sysUser) {
        return Result.ok(sysUserService.save(sysUser));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据id删除用户信息", notes = "根据id删除用户信息")
    public Result deleteGoodsById(@ApiParam(name = "id", value = "用户id", required = true) @PathVariable Integer id) {
        return Result.ok(sysUserService.removeById(id));
    }
}
