package com.kfm.system.model;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author yangbohan
 * @Date 2023/12/19 22:36
 */
@Data
public class BaseModelRole implements Serializable {
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;


    @TableField(exist = false)
    private Integer page = 1;

    @TableField(exist = false)
    private Integer size = 5;
}
