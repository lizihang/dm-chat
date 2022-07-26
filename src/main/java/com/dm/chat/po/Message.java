package com.dm.chat.po;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2022年05月14日 10:23</p>
 * <p>类全名：com.dm.chat.po.Message</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
public class Message implements Serializable {
    private static final long serialVersionUID = 1439913851628269548L;
    private Integer type;
    private Boolean mine;
    /**
     * 发送方
     */
    private String fromName;
    /**
     * 接收方
     */
    private String toName;
    /**
     * 时间
     */
    private Date date;
    /**
     * 发送的数据
     */
    private String content;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Boolean getMine() {
        return mine;
    }

    public void setMine(Boolean mine) {
        this.mine = mine;
    }

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
