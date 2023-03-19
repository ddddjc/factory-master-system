package com.djc.entity;

import java.io.Serializable;

/**
 * 权限表(Permissions)实体类
 *
 * @author djc
 * @since 2023-03-19 19:14:22
 */
public class Permissions implements Serializable {
    private static final long serialVersionUID = -57364788684025967L;
    /**
     * 权限id
     */
    private Integer id;
    /**
     * 角色
     */
    private String role;
    /**
     * 权限
     */
    private String permission;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

}

