package com.kfm.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kfm.shop.comment.ex.ServiceException;
import com.kfm.system.mapper.SysMenuMapper;
import com.kfm.system.mapper.SysUserRoleMapper;
import com.kfm.system.model.SysMenu;
import com.kfm.system.model.SysRole;
import com.kfm.system.model.SysUser;
import com.kfm.system.model.SysUserRole;
import com.kfm.system.service.SysUserRoleService;
import com.kfm.system.service.SysUserService;
import com.kfm.system.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
* @author AdminHan
* @description 针对表【sys_user】的数据库操作Service实现
* @createDate 2023-12-19 22:34:18
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
        implements SysUserService{

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(SysUser entity) {
        // 保存用户信息, 自增主键会设置到 实体中
        boolean save = super.save(entity);

        Integer[] roleIds = entity.getRoleIds();
        // 没有选择角色
        if (ObjectUtils.isEmpty(roleIds)) {
            return save;
        }
        // 保存用户角色信息
        List<SysUserRole> sysUserRoles = new ArrayList<>();
        for (Integer roleId : roleIds) {
            sysUserRoles.add(new SysUserRole().setUserId(entity.getId()).setRoleId(roleId));
        }
        // 批量保存用户角色信息
        boolean b = sysUserRoleService.saveBatch(sysUserRoles);
        return save && b;
    }

    @Override
    public String login(SysUser sysUser) {
        // 根据用户名查询用户信息
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", sysUser.getUsername());
        queryWrapper.eq("password", sysUser.getPassword());
        SysUser user = getOne(queryWrapper);
        if (ObjectUtils.isEmpty(user)) {
            throw new ServiceException("用户名或密码错误");
        }
        // TODO 生成 token
        String token = new Random().nextLong() + "";
        // 存用户信息
        redisTemplate.opsForValue().set(token, user);
        // 存用户权限信息
        // 1. 根据用户id查询角色权限
        List<SysRole> sysRoles = sysUserRoleMapper.selectRoleByUserId(user.getId());
        // 2. 根据角色信息查询权限信息
        // 获取 roles 的所有 id
        List<Integer> ids = sysRoles.stream().map((role) -> role.getId()).toList();
        if (ObjectUtils.isEmpty(ids)) {
            return token;
        }
        List<SysMenu> sysMenus = sysMenuMapper.selectMenusWithRoleIds(ids);
        // 3. 将所有权限存到 list 中
        List<String> permissions = new ArrayList<>();
        for(SysRole sysRole : sysRoles) {
            permissions.add("ROLE_" + sysRole.getRoleCode().toUpperCase());
        }
        for (SysMenu sysMenu : sysMenus) {
            permissions.add(sysMenu.getPermissionCode());
        }
        // 4. 存到 redis
        redisTemplate.opsForValue().set(token + "_permissions", permissions);
        return token;
    }
}




