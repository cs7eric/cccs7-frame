package com.cccs7.user.entity.req;

import com.cccs7.web.bean.PageRequest;
import com.cccs7.web.bean.PageResponse;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;

/**
 * (SysUser)实体类
 *
 * @author makejava
 * @since 2023-07-26 11:27:08
 */
@Data
public class SysUserReq extends PageRequest implements Serializable {

    private Long id;
    
    private String name;
    
    private Integer age;
    
    private String createBy;
    
    private Date createTime;
    
    private String updateBy;
    
    private Date updateTime;
    
    private Integer deleteFlag;
    
    private Integer version;
}

