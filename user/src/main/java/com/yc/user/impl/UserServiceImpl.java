package com.yc.user.impl;

import com.yc.user.bean.PageBean;
import com.yc.user.bean.User;
import com.yc.user.mapper.UserMapper;
import com.yc.user.myexception.LoginException;
import com.yc.user.myexception.MyException;
import com.yc.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author LX
 * @date 2019/5/26 - 20:59
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

	//判断邮箱是否合法的方法
	private boolean  isTrue(String email) {
		boolean bl=true;
		int x = email.indexOf("@");//记录@第一次出现的下标
		int y = email.indexOf(".");//记录.最后出现的下标
		if(0 == email.indexOf("@")|| email.length()-1 == email.lastIndexOf(".")|| y-x<2){
			bl=false;
		}
		return bl;
	}
	@Override
	public void changeUserEdit(long uid, String email, String sex, String qq) throws MyException {
		////////////////////邮箱验证
		if(!isTrue(email)){
			throw new MyException("您输入的邮箱不合法！");
		}
		///////////////////qq验证
		if(qq.length()<5|| qq.length()>12){
			throw new MyException("您输入的qq不合法！");
		}
        userMapper.changeUserEdit(uid,email,sex,qq);
	}

	@Override
	public void sendToManager(String title, String content) {

	}

	@Override
    public User selForLogin(String username, String password) throws LoginException {

        User user = userMapper.selByLogin(username, password);

        if(user == null){
            throw new LoginException("登录失败");
        }
        
        Jedis jedis=new Jedis("106.14.162.109",6379);
        jedis.auth("lsx666");
		
		jedis.set("user:"+user.getUid(), ""+user.getUid());
		
		Map<String,String> umap=new HashMap<String,String>();
		umap.put("uid", ""+user.getUid());
		umap.put("username", user.getUsername());
		umap.put("sex", user.getSex());
		umap.put("email", user.getEmail());
		umap.put("tel", user.getTel());
		umap.put("money", ""+user.getMoney());
		
		
		
		
		/*jedis.hmset("user:"+user.getUid(), umap);*/
		
		System.out.println("========Jedis========="+jedis.get("user:"+user.getUid()));

        return user;
    }


	public Map<String, String> getUserMap(User user) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		Map<String,String> map=new LinkedHashMap<String,String>();
		
		for(Field field:user.getClass().getDeclaredFields()) {
			String getmethod="get"+field.getName().substring(0,1).toUpperCase()+field.getName().substring(1);
			
			map.put(field.getName(), ""+user.getClass().getMethod(getmethod).invoke(user));
		}
		return map;
	}


	@Override
	public PageBean SerachPage(Integer uid, String page) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void UpdateUser(User u) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void changePwd(User u) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public User findUserById(Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
