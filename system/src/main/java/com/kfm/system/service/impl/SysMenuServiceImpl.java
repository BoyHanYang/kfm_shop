package com.kfm.system.service.impl;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import cn.hutool.core.lang.tree.parser.NodeParser;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kfm.system.model.SysMenu;
import com.kfm.system.service.SysMenuService;
import com.kfm.system.mapper.SysMenuMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
* @author AdminHan
* @description 针对表【sys_menu】的数据库操作Service实现
* @createDate 2023-12-19 22:31:02
*/
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu>
    implements SysMenuService{
    @Override
    public List<Tree<Integer>> treeList(SysMenu sysMenu) {
        // 构建查询条件
        QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
        if (!ObjectUtils.isEmpty(sysMenu) && !ObjectUtils.isEmpty(sysMenu.getName())) {
            queryWrapper.like("name", sysMenu.getName());
        }
        // 排序
        queryWrapper.orderByAsc("parent_id", "order_num");
        // 分页
//        PageHelper.startPage(sysMenu.getPage(), sysMenu.getSize());
        List<SysMenu> sysMenus = baseMapper.selectList(queryWrapper);
        // 配置
        TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
        // 设置节点名
//        treeNodeConfig.setChildrenKey("children");
        // 最大递归深度
        treeNodeConfig.setDeep(2);
        List<Tree<Integer>> treeNodes = TreeUtil.<SysMenu, Integer>build(sysMenus, 0, treeNodeConfig,
                new NodeParser<SysMenu, Integer>() {
                    @Override
                    public void parse(SysMenu treeNode, Tree<Integer> tree) {
                        tree.setId(treeNode.getId());
                        tree.setParentId(treeNode.getParentId());
                        tree.setName(treeNode.getName());
                        // 扩展属性 ...
                        tree.putExtra("permissionCode", treeNode.getPermissionCode());
                        tree.putExtra("url", treeNode.getUrl());
                        tree.putExtra("type", treeNode.getType());
                        tree.putExtra("orderNum", treeNode.getOrderNum());
                    }
                });
        return treeNodes;
    }
}




