package com.dm.chat.controller;

import com.dm.chat.cache.DataDB;
import com.dm.chat.po.User;
import com.dm.chat.vo.MessageDataParam;
import com.dm.chat.vo.Result;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
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
 * <p>创建日期：2022年05月16日 14:12</p>
 * <p>类全名：com.dm.chat.controller.ChatController</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@RestController
@RequestMapping("/chat")
@CrossOrigin
public class ChatController {

    @GetMapping("/getOnlineUserList/{username}")
    public Result getOnlineUserList(@PathVariable String username) {
        List<User> userList = new ArrayList<>();
        Set<String> usernameSet = DataDB.socketMap.keySet();
        for (String name : usernameSet) {
            if (!name.equals(username)) {
                userList.add(DataDB.onlineUsers.get(name));
            }
        }
        return Result.success(userList);
    }

    @PostMapping("/getMsgData")
    public Result getMsgData(MessageDataParam param) {
        // TODO
        return Result.success("查询成功");
    }
}
