package controller;

import bean.User;
import myexception.LoginException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;
import service.UserService;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Map;

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

    /**
     * 修改用户资料
     * 判断reids用户是否存在
     */
    @RequestMapping(value = "saveUserEdit.u" )
    public String userEdit(String email, String usecookie, String qq){
        String sex=usecookie;
        Jedis jedis=new Jedis("106.14.162.109",6379,5000);
        jedis.auth("lsx666");
        /////////////////////////////////////////////////
        if(jedis.exists("user:1")){
            Map<String,String> map=jedis.hgetAll("user:1");
            Integer id=Integer.parseInt(map.get("getUid"));
            userService.changeUserEdit(id,email,sex,qq);
            ///////修改redis里数据

        }else{
            System.out.println("未登录");
            return "login.html";
        }

        return "useredit.html";
    }

}
