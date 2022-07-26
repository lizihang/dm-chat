package com.dm.chat.util;

import com.dm.chat.cache.DataDB;
import com.dm.chat.po.ResultMessage;
import com.dm.chat.po.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2022年05月14日 10:16</p>
 * <p>类全名：com.dm.chat.util.MessageUtil</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
public class MessageUtil {

    /**
     * 封装响应的消息，注意:<b>系统消息的发送fromName为null</b>;封装好的响应如下，例如
     * 1.系统消息： {“systemMsgFlag”: true, "fromName": null, "message": ["Name1", "Name2"]}.
     * 2. 非系统消息 {“systemMsgFlag”: false, "fromName": "YYJ", "message": “你在哪里呀？”}.
     *
     * @param systemMsgFlag 是否是系统消息
     * @param fromName      发送方名称
     * @param message       发送的消息内容
     * @return java.lang.String
     */
    public static String getMessage(boolean systemMsgFlag, String fromName, Object message) {
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setSystemMsgFlag(systemMsgFlag);
        resultMessage.setMessage(message);
        // 如果不是系统消息，就传入fromName
        // if (!systemMsgFlag) {
        resultMessage.setFromName(fromName);
        // }
        ObjectMapper objectMapper = new ObjectMapper();
        String repStr = null;
        try {
            repStr = objectMapper.writeValueAsString(resultMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return repStr;
    }

    public static String buildOnlineMessage(String username, int type) {
        User user = DataDB.onlineUsers.get(username);
        user.setType(type);
        String onlineMessage = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {

            onlineMessage = objectMapper.writeValueAsString(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return onlineMessage;
    }
}
