package com.kfm.system.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author yangbohan
 * @Date 2023/12/21 20:19
 */

@Data
public class RoleGrantMenuDTO implements Serializable {

    private Integer roleId;

    private Integer[] menuIds;
}
