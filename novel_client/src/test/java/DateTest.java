import org.junit.Test;
import com.yc.novelclient.util.RedisPoolUtil;

/**
 * @author LX
 * @date 2019/5/11 - 15:26
 */
public class DateTest {

    @Test
    public void dateTest(){

       /* Date date = new Date(1501349912000l);

        System.out.println(date+"  "+System.currentTimeMillis());*/

       long t = 45l;

        System.out.println(t+"");

        System.out.println( RedisPoolUtil.getJedis().get("vip:1") );

    }
}
