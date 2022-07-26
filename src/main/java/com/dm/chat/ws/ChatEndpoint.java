package com.dm.chat.ws;

import com.dm.chat.cache.DataDB;
import com.dm.chat.po.Message;
import com.dm.chat.util.MessageUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Set;

/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2022年05月14日 10:30</p>
 * <p>类全名：com.dm.chat.ws.ChatEndpoint</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@ServerEndpoint(value = "/chat/{username}", configurator = GetHttpSessionConfigurator.class)
@Component
public class ChatEndpoint {

    private static final Logger logger = LoggerFactory.getLogger(ChatEndpoint.class);

    // 与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    // 当前用户
    private String username;

    @OnOpen
    public void onOpen(Session session, EndpointConfig config, @PathParam("username") String username) {
        logger.info("websocket建立连接！");
        this.session = session;
        this.username = username;
        //存放到onlineUsers中保存
        DataDB.socketMap.put(username, this);
        //系统消息推送所有在线用户给客户端
        //封装系统推送消息,前端onmessage接收的数据
        String message = MessageUtil.buildOnlineMessage(username, 1);
        // 通知所有客户端用户上线
        broadcastMsgToAllOnlineUsers(message);
    }


    /**
     * 接收到客户端发送的数据时调用.
     *
     * @param message 客户端发送的数据
     * @param session session对象
     * @return void
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        logger.info("websocket收到消息！");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Message msg = objectMapper.readValue(message, Message.class);
            // 消息发送方
            String username = msg.getFromName();
            // 消息接收方
            String toName = msg.getToName();
            if (username.equals(toName)) {
                return;
            }
            msg.setType(3);
            msg.setMine(false);
            // 封装发送的消息
            String sendMsg = null;
            try {
                sendMsg = objectMapper.writeValueAsString(msg);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            //发送消息
            ChatEndpoint target = DataDB.socketMap.get(toName);
            if (target == null) {
                this.session.getBasicRemote().sendText(MessageUtil.getMessage(false, username, "对方不在线"));
            } else {
                target.session.getBasicRemote().sendText(sendMsg);
            }
        } catch (JsonProcessingException e) {
            logger.error("接收客户端的消息，转换出错了！");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        logger.info("websocket关闭连接！");
        //
        ChatEndpoint remove = DataDB.socketMap.remove(username);
        // 广播
        String message = MessageUtil.buildOnlineMessage(username, 2);
        //
        DataDB.onlineUsers.remove(username);
        // 通知所有客户端用户下线
        broadcastMsgToAllOnlineUsers(message);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        logger.error(throwable.getMessage());
    }

    /**
     * 给客户端发送消息
     *
     * @param message
     */
    private void broadcastMsgToAllOnlineUsers(String message) {
        //所有登录用户名称
        Set<String> names = DataDB.socketMap.keySet();
        for (String name : names) {
            if (name.equals(username)) {
                continue;
            }
            ChatEndpoint chatEndpoint = DataDB.socketMap.get(name);
            //获取推送对象
            RemoteEndpoint.Basic basicRemote = chatEndpoint.session.getBasicRemote();
            try {
                basicRemote.sendText(message);
            } catch (IOException e) {
                logger.error("广播发送系统消息失败！{}", e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
