package com.yc.user.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
public class JsonModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int code;
	private String msg;
	private Object obj;
		
}
