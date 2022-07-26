package com.dm.chat.ws;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import java.util.Map;

/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2022年05月14日 10:35</p>
 * <p>类全名：com.dm.chat.ws.GetHttpSessionConfigurator</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
public class GetHttpSessionConfigurator extends ServerEndpointConfig.Configurator {

    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        //获取httpsession对象
        HttpSession httpSession = (HttpSession) request.getHttpSession();
        //存放httpsession对象
        Map<String, Object> userProperties = sec.getUserProperties();
        String name = HttpSession.class.getName();
        userProperties.put(name, httpSession == null ? "null" : httpSession);
    }
}
