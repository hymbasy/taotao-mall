package com.alex.dao;

import com.alex.model.UmsPermission;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface UmsAdminRoleRelationDao {
    /**
     * 获取用户所有权限(包括+-权限)
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}
