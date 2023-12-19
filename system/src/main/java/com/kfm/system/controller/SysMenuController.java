package com.kfm.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.kfm.system.model.SysMenu;
import com.kfm.system.model.SysRole;
import com.kfm.system.service.SysMenuService;
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
 * @Date 2023/12/19 23:23
 */
@RestController
@RequestMapping("/systemMenu")
public class SysMenuController {
    @Autowired
    private SysMenuService sysMenuService;
    @GetMapping
    @ApiOperation(value = "获取菜单信息", notes = "获取菜单信息")
    public Result getUser(@ApiParam(name = "goods",value = "商品信息")SysMenu sysMenu) {
        QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
        if (!ObjectUtils.isEmpty(sysMenu.getName())){
            queryWrapper.like("username",sysMenu.getName());
        }
        if (!ObjectUtils.isEmpty(sysMenu.getName())){
            queryWrapper.eq("status",sysMenu.getName());
        }
        PageHelper.startPage(sysMenu.getPage(),sysMenu.getSize());
        return Result.ok(sysMenuService.list(queryWrapper));
    }
}
