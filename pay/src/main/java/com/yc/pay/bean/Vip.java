package com.yc.pay.bean;

import java.math.BigDecimal;

import lombok.*;
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
