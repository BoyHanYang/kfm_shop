package com.kfm.system.model.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.kfm.system.model.SysUser;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @Author yangbohan
 * @Date 2023/12/21 20:20
 */

@Data
@ToString(callSuper = true)
public class SysUserDTO extends SysUser implements Serializable {

    @TableField(exist = false)
    private List<SysRoleDTO> roles;
}