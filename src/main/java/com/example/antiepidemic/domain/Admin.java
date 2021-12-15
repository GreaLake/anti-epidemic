package com.example.antiepidemic.domain;

import java.util.Date;

/**
 * @author hqb
 * 管理员表
 */
public class Admin {
    /**
     * 管理员id
     */
    private Long id;

    /**
     * 管理员用户名
     */
    private String name;

    /**
     * 管理员密码
     */
    private String passwd;

    /**
     * 管理员权限
     */
    private String role;

    /**
     * 逻辑删除
     */
    private Boolean isDelete;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 更新时间
     */
    private Date gmtUpdate;

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

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(Date gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passwd='" + passwd + '\'' +
                ", role='" + role + '\'' +
                ", isDelete=" + isDelete +
                ", gmtCreate=" + gmtCreate +
                ", gmtUpdate=" + gmtUpdate +
                '}';
    }

    public Admin(Long id, String name, String passwd, String role, Boolean isDelete, Date gmtCreate, Date gmtUpdate) {
        this.id = id;
        this.name = name;
        this.passwd = passwd;
        this.role = role;
        this.isDelete = isDelete;
        this.gmtCreate = gmtCreate;
        this.gmtUpdate = gmtUpdate;
    }
}
