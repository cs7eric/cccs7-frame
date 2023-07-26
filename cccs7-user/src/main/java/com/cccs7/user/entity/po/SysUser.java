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
public class SysUser extends BaseEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    
    private String name;
    
    private Integer age;
}

