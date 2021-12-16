package com.example.antiepidemic.dao;

import com.example.antiepidemic.domain.Admin;

import java.util.List;

public interface AdminDao {
    // 添加管理员
    int saveAdmin(Long id,String name,String password,String role);
    // 删除管理员
    int logicDelAdmin(Long id);
    // 修改某个管理员权限
    int updateAdmin(Long id);
    // 查询所有管理员信息
    List<Admin> listAdmins();
    // 根据id查询某个管理员信息
    Admin getAdminById();
}
