package com.cccs7.user.entity.req;

import lombok.Data;

import java.util.Date;

@Data
public class UserListReq {

   private Integer pageIndex;

   private Integer pageSize;
}
