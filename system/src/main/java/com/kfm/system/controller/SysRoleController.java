package com.kfm.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.kfm.system.model.SysRole;
import com.kfm.system.model.SysUser;
import com.kfm.system.service.SysRoleService;
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
 * @Date 2023/12/19 23:17
 */
@RestController
@RequestMapping("/systemRole")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;
    @GetMapping
    @ApiOperation(value = "获取用户信息", notes = "获取用户信息")
    public Result getUser(@ApiParam(name = "goods",value = "商品信息")SysRole sysRole) {
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        if (!ObjectUtils.isEmpty(sysRole.getName())){
            queryWrapper.like("username",sysRole.getName());
        }
        if (!ObjectUtils.isEmpty(sysRole.getName())){
            queryWrapper.eq("status",sysRole.getName());
        }
        PageHelper.startPage(sysRole.getPage(),sysRole.getSize());
        return Result.ok(sysRoleService.list(queryWrapper));
    }
}
