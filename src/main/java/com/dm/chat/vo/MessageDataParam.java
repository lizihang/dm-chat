package com.dm.chat.vo;

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
 * <p>创建日期：2022年05月17日 15:43</p>
 * <p>类全名：com.dm.chat.vo.MessageDataParam</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
public class MessageDataParam implements Serializable {
    private static final long serialVersionUID = -1695539374017090751L;

    private String fromName;
    private String toName;

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }
}
