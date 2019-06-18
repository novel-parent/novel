package com.yc.user.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yc.user.bean.Message;
import com.yc.user.bean.PageBean;
import com.yc.user.bean.User;
import com.yc.user.bean.Vip;
import com.yc.user.mapper.MessageMapper;
import com.yc.user.mapper.UserMapper;
import com.yc.user.myexception.LoginException;
import com.yc.user.myexception.MyException;
import com.yc.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author LX
 * @date 2019/5/26 - 20:59
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private MessageMapper messageMapper;

	//判断邮箱是否合法的方法
	private boolean isTrue(String email) {
		boolean bl = true;
		int x = email.indexOf("@");//记录@第一次出现的下标
		int y = email.indexOf(".");//记录.最后出现的下标
		if (0 == email.indexOf("@") || email.length() - 1 == email.lastIndexOf(".") || y - x < 2) {
			bl = false;
		}
		return bl;
	}

	@Override
	public void changeUserEdit(long uid, String email, String sex, String qq) throws MyException {
		////////////////////邮箱验证
		if (!isTrue(email)) {
			throw new MyException("您输入的邮箱不合法！");
		}
		///////////////////qq验证
		if (qq.length() < 5 || qq.length() > 12) {
			throw new MyException("您输入的qq不合法！");
		}
		userMapper.changeUserEdit(uid, email, sex, qq);
	}

	/**
	 * 发送消息给管理员(uid:1)
	 * 连续发送2次，禁止发送10分钟
	 * redis保存为：(usertomanager，x)
	 */
	@Override
	public void sendToManager(String title, String content) throws MyException{
		int uid=2;////////暂时为2 测试
		//判空
		if(title.isEmpty() || title==null ||content.isEmpty()||content==null ){
			throw new MyException();
		}
		Jedis jedis=new Jedis("106.14.162.109",6379,5000);
		jedis.auth("lsx666");
		if(jedis.exists("usertomanager:"+uid)){
			int sendNum=Integer.parseInt(jedis.get("usertomanager:"+uid));
			if(sendNum>=2){			///2条消息，开始限制
				throw new MyException("发送过多，请5分钟后再试。。。");
			}
			messageMapper.insert(uid,1,new Date(System.currentTimeMillis()),title,content);
			jedis.setex("usertomanager:"+uid,300,(sendNum+1)+"");
		}else{
			messageMapper.insert(uid,1,new Date(System.currentTimeMillis()),title,content);
			jedis.setex("usertomanager:"+uid,300,1+"");
		}
		jedis.close();
	}

	@Override
	public User selForLogin(String username, String password) throws LoginException {

		User user = userMapper.selByLogin(username, password);

		if (user == null) {
			throw new LoginException("登录失败");
		}

		Jedis jedis = new Jedis("106.14.162.109", 6379);
		jedis.auth("lsx666");

		jedis.set("user:" + user.getUid(), "" + user.getUid());

		Map<String, String> umap = new HashMap<String, String>();
		umap.put("uid", "" + user.getUid());
		umap.put("username", user.getUsername());
		umap.put("sex", user.getSex());
		umap.put("email", user.getEmail());
		umap.put("tel", user.getTel());
		umap.put("money", "" + user.getMoney());

		return user;
	}

	@Override
	public Map<String, String> getUserMap(User user) throws Exception {

		Map<String, String> map = new LinkedHashMap<String, String>();

		for (Field field : user.getClass().getDeclaredFields()) {
			String getmethod = "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);

			map.put(field.getName(), "" + user.getClass().getMethod(getmethod).invoke(user));
		}
		return map;
	}

	@Override
	public PageBean SerachPage(Integer uid, String page) {
		PageBean pb=new PageBean();
		Page<Message> msgList = PageHelper.startPage(0, 20);
		userMapper.SerachPage(uid);
		return pb.setCurrengPagenum(0).setPageList(msgList.getResult()).setTotalpagenum((int) msgList.getTotal());
	}


	@Override
	public void UpdateUser(User u) {
		userMapper.upadateUser(u);
	}


	@Override
	public void changePwd(User u) {
		userMapper.changePwd(u);
	}


	@Override
	public User findUserById(Integer uid) {
		return userMapper.findUserById(uid);
	}

	@Override
	public User getEditUser(User user) {
		return userMapper.findUserById(Integer.valueOf(user.getUid()+""));
	}

	@Override
	public int chongZhiVip(long uid,int money) {
		
		long currTime=System.currentTimeMillis();
		
		long endTime =currTime;
		
		if(1 == money) {
			endTime=endTime + 60*60*24*30;
			
		}else if(3 == money) {
			endTime=endTime + 60*60*24*90;
		}else if(6 == money) {
			endTime=endTime + 60*60*24*180;
		}else {
			endTime=endTime + 60*60*24*360;
		}
		
	    return	userMapper.chongZhiVip(uid,currTime,endTime);
		
	}

	@Override
	public void chongZhiCode(long uid, int money) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void UpdateUserVip(long uid) {
		userMapper.UpdateUserVip(uid);
		
	}

	@Override
	public Vip findUserIsOrNotVip(long uid) {
		return userMapper.findUserIsOrNotVip(uid);
	}

	@Override
	public int UpdateUsersVip(long uid, int money,Vip vip) {
		
		long endTime =vip.getEndTimes();
		
		if(1 == money) {
			endTime=endTime + 60*60*24*30;
			
		}else if(3 == money) {
			endTime=endTime + 60*60*24*90;
		}else if(6 == money) {
			endTime=endTime + 60*60*24*180;
		}else {
			endTime=endTime + 60*60*24*360;
		}
		
		return userMapper.UpdateUsersVip(uid,endTime);
	}


}
