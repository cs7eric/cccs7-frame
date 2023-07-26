package com.cccs7.user.entity.dto;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (SysUser)实体类
 *
 * @author makejava
 * @since 2023-07-26 11:27:08
 */
@Data
public class SysUserDto implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    
    private String name;
    
    private Integer age;

    private String createBy;

    private Date createTime;

    private  String updateBy;

    private  Date updateTime;

    private Integer deleteFlag;

    private Integer version;
}

