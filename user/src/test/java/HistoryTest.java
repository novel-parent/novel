import com.yc.user.mapper.HistoryMapper;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author LX
 * @date 2019/5/27 - 19:45
 */

public class HistoryTest {

    @Test
    public void test1(){

        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        HistoryMapper historyMapper = ac.getBean(HistoryMapper.class);

        System.out.println(historyMapper.selForHistorySearch(1l));
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
}
