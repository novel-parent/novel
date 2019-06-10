<<<<<<< HEAD
import bean.History;
import mapper.HistoryMapper;
import mapper.UserMapper;

=======
import com.yc.user.mapper.HistoryMapper;
>>>>>>> 7cbcc8c1b613281e7f6b330daf7ec482042452f7
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.github.pagehelper.PageHelper;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author LX
 * @date 2019/5/27 - 19:45
 */

public class HistoryTest {
	
	@Autowired
	private UserMapper um;

    @Test
    public void test1(){

        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        HistoryMapper historyMapper = ac.getBean(HistoryMapper.class);

        System.out.println(um.findUserById(2));
    }

    @Test
    public void DateTest(){
        Date date = new Date();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String format = formatter.format(date);

//        LocalDateTime now = LocalDateTime.now();
//        String format1 = now.format(formatter);
//
//        System.out.println(format1);
        System.out.println(format);
    }
    
    @Test
    public void PageTest() {
    	
    }
}
