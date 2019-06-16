package com.yc.loginregister.bean;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain=true)
public class CookieModel {
	private String username;
	private String password;
}
