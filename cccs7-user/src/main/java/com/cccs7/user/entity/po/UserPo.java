package com.cccs7.user.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import com.cccs7.mybatisplus.handler.entity.BaseEntity;
import lombok.Data;

import java.util.Date;

@Data
@TableName("user")
public class UserPo extends BaseEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;

    private Integer age;
}
