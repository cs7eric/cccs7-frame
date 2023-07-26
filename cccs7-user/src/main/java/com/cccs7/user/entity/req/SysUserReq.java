package com.cccs7.user.entity.req;

import com.cccs7.web.bean.PageRequest;
import com.cccs7.web.bean.PageResponse;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;

/**
 * (SysUser)实体类
 *
 * @author makejava
 * @since 2023-07-26 11:27:08
 */
public class SysUserReq extends PageRequest implements Serializable {

    private Long id;
    
    private String name;
    
    private Integer age;
    
    private String createBy;
    
    private LocalTime createTime;
    
    private String updateBy;
    
    private Date updateTime;
    
    private Integer deleteFlag;
    
    private Integer version;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalTime createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

}

