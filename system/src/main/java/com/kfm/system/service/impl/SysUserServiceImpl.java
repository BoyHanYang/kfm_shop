package com.kfm.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kfm.system.model.SysUser;
import com.kfm.system.service.SysUserService;
import com.kfm.system.mapper.SysUserMapper;
import org.springframework.stereotype.Service;

/**
* @author AdminHan
* @description 针对表【sys_user】的数据库操作Service实现
* @createDate 2023-12-19 22:34:18
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService{

}




