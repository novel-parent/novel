package com.yc.user.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.yc.user.bean.JsonModel;
import com.yc.user.bean.PageBean;
import com.yc.user.bean.User;
import com.yc.user.bean.Vip;
import com.yc.user.config.AlipayConfig;
import com.yc.user.myexception.LoginException;
import com.yc.user.service.UserService;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

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

	private Jedis jedis;

	private AlipayClient client;
	private AlipayTradePagePayRequest request;

	@ModelAttribute
	public void init() {
		jedis = new Jedis("106.14.162.109", 6379, 5000);
		jedis.auth("lsx666");
		client = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id,
				AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key,
				AlipayConfig.sign_type);
		request = new AlipayTradePagePayRequest();
		request.setReturnUrl(AlipayConfig.return_url);
		request.setNotifyUrl(AlipayConfig.notify_url);
	}

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

	@RequestMapping(value = "getuser.u", method = RequestMethod.POST)
	@ResponseBody
	public Object getUser(Integer uid) {

		if (jedis.exists("uid:" + uid)) {

			return "redirect:login.html";

		}

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
	public String changePwd(User user) {

		userService.changePwd(user);

		return "redirect:/login.html";
	}

	/**
	 * @author HDL
	 * @date 2019/5/26 - 20:57 用户消息
	 */

	@RequestMapping("getpage.u")
	@ResponseBody
	public Object GetPage(Integer uid, String page) {

		if (jedis.exists("uid:" + uid)) {

			return "redirect:login.html";

		}

		PageBean pb = userService.SerachPage(uid, page);

		JsonModel jm = new JsonModel();

		jm.setCode(1).setMsg("ok").setObj(pb);

		return jm;
	}

	/**
	 * 修改用户资料 判断reids用户是否存在
	 */
	@RequestMapping(value = "saveUserEdit.u")
	public String userEdit(String email, String usecookie, String qq, String uid) {

		String sex = usecookie;

		/////////////////////////////////////////////////
		if (jedis.exists("user:" + uid)) {
			// Map<String,String> map=jedis.hgetAll("user:1");
			// Integer id=Integer.parseInt(map.get("getUid"));
			Integer id = Integer.parseInt(jedis.get("user:1"));
			try {
				userService.changeUserEdit(id, email, sex, qq);
				/////// 修改redis里数据

				return "redirect:/useredit.html";
			} catch (Exception e) {
				System.err.println(e.getMessage());
				return "redirect:/login.html";
			} finally {
				jedis.close();
			}
		} else {
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
	public String sendToManager(String title, String content) {
		try {
			userService.sendToManager(title, content);
			return "ok";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@RequestMapping("getuseredit.u")
	@ResponseBody
	public Object getEditUser(User user) {
		JsonModel jm = new JsonModel();

		jm.setCode(1).setObj(userService.getEditUser(user));

		return jm;
	}

	@RequestMapping("exitlogin.u")
	@ResponseBody
	public Object exitLogin(String uid) {
		JsonModel jm = new JsonModel();

		if (jedis.exists("uid:" + uid)) {
			jedis.expire("uid:" + uid,1);
		}

		jm.setCode(1);

		return jm;
	}

	@RequestMapping("chongzhi.u")
	@ResponseBody
	public Object chongZhin(long uid, int money, String type) throws AlipayApiException {

		if (jedis.exists("uid:" + uid)) {

			return "redirect:login.html";

		}

		JsonModel jm = new JsonModel();

		jedis.set("money:" + uid, money + "");

		request.setBizContent("{\"out_trade_no\":\"" + uid + ":" + type + ":" + UUID.randomUUID() + "\","
				+ "\"total_amount\":\"" + money + "\"," + "\"subject\":\"" + "" + type + "\","
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
		String result = client.pageExecute(request).getBody();

		jm.setObj(result).setCode(1);

		return jm;
	}

	@RequestMapping("chongzhihou.u")
	public Object chongZhiHou(HttpServletRequest request) throws UnsupportedEncodingException, AlipayApiException {

		JsonModel jm = new JsonModel();

		Map<String, String> params = new HashMap<String, String>();
		Map<String, String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}

		boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset,
				AlipayConfig.sign_type); // 调用SDK验证签名

		if (signVerified) {

			String tradeno = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

			String uid = tradeno.split(":")[0];
			String type = tradeno.split(":")[1];
			// 支付宝交易号
			/*
			 * String subject = new
			 * String(request.getParameter("subject").getBytes("ISO-8859-1"),"UTF-8");
			 */

			// 付款金额
			String money = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");

			System.out.println(uid + ":===================:" + type + ":================" + money);

			if ("vip".equals(type)) {

				Vip vip = userService.findUserIsOrNotVip(Long.parseLong(uid.substring(0, 1)));

				if (vip == null) {
					userService.chongZhiVip(Long.parseLong(uid.substring(0, 1)),
							Integer.parseInt(money.substring(0, 1)));

					userService.UpdateUserVip(Long.parseLong(uid.substring(0, 1)));
				} else {
					userService.UpdateUsersVip(Long.parseLong(uid.substring(0, 1)),
							Integer.parseInt(money.substring(0, 1)), vip);
				}

			} else {
			}
		}

		return "redirect:chongzhi.html?uid=" + 2 + "&code=" + 1;
	}

}
