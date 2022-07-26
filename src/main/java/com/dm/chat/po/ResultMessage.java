package com.dm.chat.po;

import java.io.Serializable;

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
 * <p>类全名：com.dm.chat.po.ResultMessage</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
public class ResultMessage implements Serializable {
    private static final long serialVersionUID = 2707993408598176998L;
    /**
     * 是否是系统消息
     */
    private boolean systemMsgFlag;
    /**
     * 发送方Name
     */
    private String fromName;
    /**
     * 发送的数据
     */
    private Object message;

    public boolean isSystemMsgFlag() {
        return systemMsgFlag;
    }

    public void setSystemMsgFlag(boolean systemMsgFlag) {
        this.systemMsgFlag = systemMsgFlag;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }
}
