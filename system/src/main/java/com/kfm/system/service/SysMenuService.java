package com.kfm.system.service;

import cn.hutool.core.lang.tree.Tree;
import com.kfm.system.model.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author AdminHan
* @description 针对表【sys_menu】的数据库操作Service
* @createDate 2023-12-19 22:31:02
*/
public interface SysMenuService extends IService<SysMenu> {
    List<Tree<Integer>> treeList(SysMenu sysMenu);
}
