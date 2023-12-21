package com.kfm.system.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 
 * @TableName sys_user_role
 */
@TableName(value ="sys_user_role")
@Data
@Accessors(chain = true)
public class SysUserRole implements Serializable {
    /**
     * 用户id
     */
    @TableId
    private Integer userId;

    /**
     * 角色id
     */
    @TableId
    private Integer roleId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}