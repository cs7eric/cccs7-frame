package com.cccs7.user.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import com.cccs7.mybatisplus.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * (SysUser)实体类
 *
 * @author makejava
 * @since 2023-07-26 11:27:08
 */
@Data
@TableName("sys_user")
public class SysUser implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    
    private String name;
    
    private Integer age;

    @TableField(value = "create_by",fill = FieldFill.INSERT)
    private String createBy;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_by",fill = FieldFill.UPDATE)
    private  String updateBy;

    @TableField(value = "update_time",fill = FieldFill.UPDATE)
    private  Date updateTime;

    @TableLogic
    @TableField(value = "delete_flag",fill = FieldFill.INSERT)
    private Integer deleteFlag;

    @TableField(value = "version", fill = FieldFill.INSERT)
    private Integer version;
}

