package com.cccs7.mybatisplus.handler.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {
    @TableField(value = "create_by",fill = FieldFill.INSERT)
    private String createBy;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_time",fill = FieldFill.UPDATE)
    private  String updateBy;

    @TableField(value = "update_time",fill = FieldFill.UPDATE)
    private  Date updateTime;

    @TableLogic
    @TableField(value = "delete_flag",fill = FieldFill.INSERT)
    private Integer deleteFlag;

    @TableField(value = "version", fill = FieldFill.INSERT)
    private Integer version;
}
