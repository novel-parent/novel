package com.yc.redis.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author LX
 * @date 2019/5/1 - 18:24
 */

@AllArgsConstructor
@Data
@Accessors(chain=true)
public class User implements Serializable{
	public User() {
	}

	private static final long serialVersionUID = 1L;

	private long uid;

	private String username;

	private String password;

	private double money;

	private String tel;

	private String email;

	private int age;

	private String sex;

	private String qq;
	
	private Integer integral;
	
	private String title;
	
	private String regtime;
	
	private String level;
	
	private Vip vip;

}
