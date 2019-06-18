package com.yc.redis.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain=true)
public class Vip {
	private long vip;
	private long uid;
	private long startTimes;
	private long endTimes;
	private long flag;
}
