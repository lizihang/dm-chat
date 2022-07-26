package com.dm.chat.cache;

import com.dm.chat.po.User;
import com.dm.chat.ws.ChatEndpoint;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2022年05月17日 15:54</p>
 * <p>类全名：com.dm.chat.cache.DataDB</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
public class DataDB {

    public static final Map<String, User> onlineUsers = new ConcurrentHashMap<>();

    //
    public static final Map<String, ChatEndpoint> socketMap = new ConcurrentHashMap<>();
}
