package com.djc.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author: djc
 * @Date: 2023-04-17-22:25
 * @Description: 权限类
 */
@Data
public class Permission {
    List<String> menus;
    List<String> points;
}
