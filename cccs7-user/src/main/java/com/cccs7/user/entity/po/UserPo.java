package com.cccs7.user.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("user")
public class UserPo {

    @TableId(value="id", type = IdType.AUTO)
    private Long id;

    private String name;

    private Integer age;

    @TableField(value = "create_by",fill = FieldFill.INSERT)
    private String createBy;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_time",fill = FieldFill.UPDATE)
    private  String updateBy;

    @TableField(value = "update_time",fill = FieldFill.UPDATE)
    private  Date updateTime;

    @TableField(value = "delete_flag",fill = FieldFill.INSERT)
    @TableLogic
    private Integer deleteFlag;

    @TableField(value = "version", fill = FieldFill.INSERT)
    private Integer version;
}
