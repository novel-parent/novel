package com.yc.novelclient.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

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
