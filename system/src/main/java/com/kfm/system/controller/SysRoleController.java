package com.kfm.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.kfm.system.model.SysRole;
import com.kfm.system.model.SysUser;
import com.kfm.system.model.dto.RoleGrantMenuDTO;
import com.kfm.system.service.SysRoleService;
import com.kfm.system.service.SysUserService;
import com.kfm.system.util.Result;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取角色信息", notes = "根据id获取角色信息")
    public Result getGoodsById(@ApiParam(name = "id", value = "角色id", required = true) @PathVariable Integer id) {
        return Result.ok(sysRoleService.getById(id));
    }


    @PostMapping
    @ApiOperation(value = "根据id修改角色信息", notes = "根据id修改角色信息")
    public Result updateGoodsById(@ApiParam(name = "sysRole", value = "角色信息", required = true) SysRole sysRole) {
        return Result.ok(sysRoleService.updateById(sysRole));
    }


    @PutMapping
    @ApiOperation(value = "新增角色信息", notes = "新增角色信息")
    public Result addGoods(@ApiParam(name = "sysRole", value = "角色信息", required = true) @RequestBody SysRole sysRole) {
        return Result.ok(sysRoleService.save(sysRole));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据id删除角色信息", notes = "根据id删除角色信息")
    public Result deleteGoodsById(@ApiParam(name = "id", value = "角色id", required = true) @PathVariable Integer id) {
        return Result.ok(sysRoleService.removeById(id));
    }

    /**
     * 授权
     */
    @PostMapping("/grant")
    public Result grantMenu(@RequestBody RoleGrantMenuDTO roleGrantMenuDTO){
        return Result.ok(sysRoleService.grant(roleGrantMenuDTO));
    }
}
