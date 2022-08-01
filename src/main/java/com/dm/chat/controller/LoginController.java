package com.dm.chat.controller;

import com.dm.chat.cache.DataDB;
import com.dm.chat.po.User;
import com.dm.chat.vo.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2022年05月14日 10:01</p>
 * <p>类全名：com.dm.chat.controller.LoginController</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@RestController
@CrossOrigin
public class LoginController {

    @PostMapping(value = "/login")
    public Result login(User user) {
        DataDB.onlineUsers.put(user.getUsername(), user);
        return Result.success("登录成功");
    }
}
