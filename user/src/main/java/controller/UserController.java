package controller;

import bean.JsonModel;
import bean.Message;
import bean.PageBean;
import bean.User;
import myexception.LoginException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import service.UserService;

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

}
