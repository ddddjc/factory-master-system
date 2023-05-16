package com.djc.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@Slf4j
@ServerEndpoint("/websocket/{employeeId}")  // 接口路径 ws://localhost:8087/webSocket/{employeeId};

public class WebSocket {
    
    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
        /**
     * 用户ID
     */
    private Integer employeeId;

    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    //虽然@Component默认是单例模式的，但springboot还是会为每个websocket连接初始化一个bean，所以可以用一个静态set保存起来。
    //  注：底下WebSocket是当前类名

    private static CopyOnWriteArraySet<WebSocket> webSockets =new CopyOnWriteArraySet<>();
    // 用来存在线连接用户信息
    private static ConcurrentHashMap<Integer,Session> sessionPool = new ConcurrentHashMap<Integer,Session>();
    /**
     * 链接成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam(value="employeeId")Integer employeeId) {
        try {
            this.session = session;
            this.employeeId = employeeId;
            int before=sessionPool.size();
            sessionPool.put(employeeId, session);
            int aft = sessionPool.size();
            if (aft!=before)  webSockets.add(this);//若无重复，则把socket加进去
            log.info("【websocket消息】有新的连接，总数为:"+webSockets.size());
        } catch (Exception e) {
        }
    }

    /**
     * 链接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        try {
            webSockets.remove(this);
            sessionPool.remove(this.employeeId);
            log.info("【websocket消息】连接断开，总数为:"+webSockets.size());
        } catch (Exception e) {
        }
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message
     */
    @OnMessage
    public void onMessage(String message) {
        log.info("【websocket消息】收到客户端消息:"+message);
    }
    /** 发送错误时的处理
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {

        log.error("用户错误,原因:"+error.getMessage());
        error.printStackTrace();
    }


    // 此为广播消息

    public void sendAllMessage(String message) {
        log.info("【websocket消息】广播消息:"+message);
        for(WebSocket webSocket : webSockets) {
            try {
                if(webSocket.session.isOpen()) {
                    webSocket.session.getAsyncRemote().sendText(message);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    // 此为单点消息

    public void sendOneMessage(Integer employeeId, String message) {
        Session session = sessionPool.get(employeeId);
        if (session != null&&session.isOpen()) {
            try {
                log.info("【websocket消息】 单点消息:"+message);
                session.getAsyncRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    // 此为单点消息(多人)

    public void sendMoreMessage(Integer employeeIds[], String message) {
        for(Integer employeeId:employeeIds) {
            Session session = sessionPool.get(employeeId);
            if (session != null&&session.isOpen()) {
                try {
                    log.info("【websocket消息】 单点消息:"+message);
                    session.getAsyncRemote().sendText(message);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public Session getSession() {
        return session;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public static CopyOnWriteArraySet<WebSocket> getWebSockets() {
        return webSockets;
    }

    public static void setWebSockets(CopyOnWriteArraySet<WebSocket> webSockets) {
        WebSocket.webSockets = webSockets;
    }

    public static ConcurrentHashMap<Integer, Session> getSessionPool() {
        return sessionPool;
    }

    public static void setSessionPool(ConcurrentHashMap<Integer, Session> sessionPool) {
        WebSocket.sessionPool = sessionPool;
    }
}
