package com.yc.user.controller;

import com.yc.user.bean.User;
import com.yc.user.myexception.LoginException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yc.user.service.UserService;


/**
 * @author LX
 * @date 2019/5/26 - 20:57
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "login.u" )
    public String login(@RequestParam("username") String username ,@RequestParam("password") String password,@RequestParam("flag") boolean flag ){

        String message = "-1";

        try {
            User user = userService.selForLogin(username, password);

            message = "uid ="+ user.getUid();

        } catch (LoginException e) {
            // 登录失败
            e.printStackTrace();
        }

        return message;
    }

}
