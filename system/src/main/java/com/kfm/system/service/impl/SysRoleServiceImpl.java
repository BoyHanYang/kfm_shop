package com.kfm.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kfm.system.model.SysRole;
import com.kfm.system.model.SysRoleMenu;
import com.kfm.system.model.dto.RoleGrantMenuDTO;
import com.kfm.system.service.SysRoleMenuService;
import com.kfm.system.service.SysRoleService;
import com.kfm.system.mapper.SysRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
* @author AdminHan
* @description 针对表【sys_role】的数据库操作Service实现
* @createDate 2023-12-19 22:34:05
*/
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole>
    implements SysRoleService{
    @Autowired
    private SysRoleMenuService sysRoleMenuService;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean grant(RoleGrantMenuDTO roleGrantMenuDTO) {
        // 先将原来的权限删掉，再添加新权限
        sysRoleMenuService.removeById(roleGrantMenuDTO.getRoleId());

        Integer[] menuIds = roleGrantMenuDTO.getMenuIds();
        List<SysRoleMenu> list = new ArrayList<>();
        for (Integer menuId : menuIds){
            list.add(new SysRoleMenu(roleGrantMenuDTO.getRoleId(), menuId));
        }

        return sysRoleMenuService.saveBatch(list);
    }
}




