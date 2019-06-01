package util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author LX
 * @date 2019/5/29 - 21:44
 */
public class DateUtil {

    /**
     * 将当前时间转化为  yyyy-MM-dd HH:mm:ss 时间
     * @return
     */
    public static String getDate(){

        Date date = new Date();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        String format = formatter.format(date);

        return format;
    }
}
