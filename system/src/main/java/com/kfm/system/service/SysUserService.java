package com.kfm.system.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kfm.system.model.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author AdminHan
* @description 针对表【sys_user】的数据库操作Service
* @createDate 2023-12-19 22:34:18
*/
public interface SysUserService extends IService<SysUser> {
    String login(SysUser sysUser);
}
