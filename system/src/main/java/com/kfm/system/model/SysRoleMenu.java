package com.kfm.system.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName sys_role_menu
 */
@TableName(value ="sys_role_menu")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysRoleMenu implements Serializable {
    /**
     * 角色id
     */
    @TableId
    private Integer roleId;

    /**
     * 菜单id
     */
    private Integer menuId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}