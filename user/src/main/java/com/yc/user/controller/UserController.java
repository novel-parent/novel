package com.yc.user.controller;


import com.yc.user.bean.JsonModel;
import com.yc.user.bean.PageBean;
import com.yc.user.bean.User;
import com.yc.user.myexception.LoginException;
import com.yc.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

/**
 * @author LX
 * @date 2019/5/26 - 20:57
 */
@Controller
@SessionAttributes("loginedUser")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "login.u")
	@ResponseBody
	public String login(Model model, @RequestParam("username") String username,
						@RequestParam("password") String password, @RequestParam("flag") boolean flag) {

		String message = "-1";

		try {
			User user = userService.selForLogin(username, password);

			message = "uid =" + user.getUid();

			model.addAttribute("loginedUser", user);

		} catch (LoginException e) {
			// 登录失败
			e.printStackTrace();
		}

		return message;
	}

	/**
	 * @author HDL
	 * @date 2019/5/26 - 20:57 根据用户id查找用户
	 */

	@RequestMapping("getuser.u")
	@ResponseBody
	public Object getUser(Integer uid) {

		JsonModel jm = new JsonModel();

		User dbuser = userService.findUserById(uid);

		if (dbuser != null) {
			jm.setObj(dbuser);
			jm.setCode(1);
		} else {
			jm.setCode(-1);
			jm.setMsg("没有该用户");
		}

		return jm;
	}

	/**
	 * @author HDL
	 * @date 2019/5/26 - 20:57 更新用户信息,根据用户名
	 */

	@RequestMapping("updateuser.u")
	@ResponseBody
	public Object UpdataUserInfo(User user) {

		JsonModel jm = new JsonModel();

		userService.UpdateUser(user);

		jm.setCode(1).setMsg("用户信息修改成功！");

		return jm;
	}

	/**
	 * @author HDL
	 * @date 2019/5/26 - 20:57 修改密码
	 */

	@RequestMapping("changepwd.u")
	@ResponseBody
	public Object changePwd(User u) {

		JsonModel jm = new JsonModel();

		userService.changePwd(u);

		jm.setCode(1).setMsg("密码修改成功");

		return jm;
	}

	/**
	 * @author HDL
	 * @date 2019/5/26 - 20:57 用户消息
	 */

	@RequestMapping("getpage.u")
	@ResponseBody
	public Object GetPage(Integer uid, String page) {
		
		PageBean pb = userService.SerachPage(uid, page);
		
		JsonModel jm = new JsonModel();

		jm.setCode(1).setMsg("ok").setObj(pb);

		return jm;
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
 //         Map<String,String> map=jedis.hgetAll("user:1");
 //         Integer id=Integer.parseInt(map.get("getUid"));
			Integer id=Integer.parseInt(jedis.get("user:1"));
            try {
            	userService.changeUserEdit(id,email,sex,qq);
				///////修改redis里数据

				return "redirect:/useredit.html";
			}catch (Exception e){
				System.err.println(e.getMessage());
				return "redirect:/login.html";
			}finally {
				jedis.close();
			}
        }else{
            System.out.println("未登录");
			jedis.close();
            return "redirect:/login.html";
        }
    }

	/**
	 * 用户发送给管理员消息
	 */
	@ResponseBody
	@PostMapping("sendToManager.u")
    public String sendToManager(String title ,String content){
		userService.sendToManager(title,content);
    	return "ok";
	}


}
