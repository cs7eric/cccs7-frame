package com.cccs7.user.convert;

import com.cccs7.user.entity.po.SysUser;
import com.cccs7.user.entity.req.SysUserReq;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SysUserConverter {

    SysUserConverter INSTANCE = Mappers.getMapper(SysUserConverter.class);

    SysUser convertReqToSysUser(SysUserReq sysUserReq);
}
