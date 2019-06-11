package com.yc.loginregister.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Vip implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private long vid;
	
	private Integer uid;
	
	private BigDecimal startTime;
	
	private BigDecimal endTime;
	
	private Integer flag;
	
}
