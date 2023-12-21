package com.kfm.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kfm.system.model.SysUser;
import com.kfm.system.model.SysUserRole;
import com.kfm.system.service.SysUserRoleService;
import com.kfm.system.service.SysUserService;
import com.kfm.system.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

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
}




