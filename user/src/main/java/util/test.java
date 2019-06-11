package util;

import com.yc.user.bean.User;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;


public class test {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Field[] f= User.class.getDeclaredFields();
		
		User u=new User();
		u.setAge(12);
		u.setUid(1);
		u.setUsername("sdfsd");
		
		Set<String> set=new HashSet<String>();
		
		for(Field fi: f) {
			String field="get"+fi.getName().substring(0, 1).toUpperCase()+fi.getName().substring(1);
			set.add(field);
		}
		
		
		for(String method:set) {
			Method mu= User.class.getMethod(method);
			Object s= mu.invoke(u);
			System.out.println(s);
		}
		
		
	}

}
