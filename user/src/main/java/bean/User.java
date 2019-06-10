package bean;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author LX
 * @date 2019/5/1 - 18:24
 */

@AllArgsConstructor
@Data
@NoArgsConstructor
@Accessors(chain=true)
public class User {

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

}
