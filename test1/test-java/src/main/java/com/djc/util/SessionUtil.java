package com.djc.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component // 将SessionUtil类标记为Spring Bean
public class SessionUtil {

    private final HttpServletRequest request; // 使用构造函数注入HttpServletRequest

    @Autowired
    public SessionUtil(HttpServletRequest request) { // 构造函数注入HttpServletRequest
        this.request = request;
    }

    // 设置会话属性
    public void setAttribute(String name, Object value) {
        HttpSession session = request.getSession(); // 获取HttpSession
        session.setAttribute(name, value); // 设置属性值
    }

    // 获取会话属性
    public Object getAttribute(String name) {
        HttpSession session = request.getSession(false); // 获取HttpSession（不创建新的）
        return session != null ? session.getAttribute(name) : null; // 返回属性值或null
    }

    // 删除会话属性
    public void removeAttribute(String name) {
        HttpSession session = request.getSession(false); // 获取HttpSession（不创建新的）
        if (session != null) {
            session.removeAttribute(name); // 删除属性
        }
    }

    // 使会话无效
    public void invalidate() {
        HttpSession session = request.getSession(false); // 获取HttpSession（不创建新的）
        if (session != null) {
            session.invalidate(); // 使会话无效
        }
    }
}
