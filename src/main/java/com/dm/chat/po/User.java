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
 * <p>创建日期：2022年05月14日 10:23</p>
 * <p>类全名：com.dm.chat.po.User</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1331837012048533460L;

    private String username;
    private String avatar;
    private String dept;
    private Integer type;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
