package bean;

import com.yc.user.bean.User;

import lombok.*;
import lombok.experimental.Accessors;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain=true)
public class Message {
	private Integer id;
	private Integer uid;
	private Integer receiver;
	private String senddate;
	private String title;
	private String content;
	
	
	private User user;
}
