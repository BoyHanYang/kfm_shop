package com.kfm.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.kfm.system.model.SysUser;
import com.kfm.system.service.SysUserService;
import com.kfm.system.util.Result;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yangbohan
 * @Date 2023/12/19 23:09
 */
@RestController
@RequestMapping("/systemUser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;
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
}
