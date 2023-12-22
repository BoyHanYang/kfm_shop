package com.kfm.system.mapper;

import com.kfm.system.model.SysRole;
import com.kfm.system.model.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author AdminHan
* @description 针对表【sys_user_role】的数据库操作Mapper
* @createDate 2023-12-21 17:24:11
* @Entity com.kfm.system.model.SysUserRole
*/
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {
    List<SysRole> selectRoleByUserId(Integer userId);
}




