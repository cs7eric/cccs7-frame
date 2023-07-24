package com.cccs7.user.entity.req;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class UserReq {

    @TableId(value="id", type = IdType.AUTO)
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
