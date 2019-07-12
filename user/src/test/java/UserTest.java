import com.yc.user.impl.UserServiceImpl;
import com.yc.user.service.UserService;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml","classpath:springmvc.xml"})*/
public class UserTest {

    UserService us=new UserServiceImpl();

    @Test
    public void changeUser(){
        try {
            us.changeUserEdit(1,"1023@qq.com","1","1023");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void selByLg(){
        try {
            us.selForLogin("root","a");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void testRedis(){
        redis.clients.jedis.Jedis jd=new Jedis("106.14.162.109",6379,50000);
        jd.auth("lsx666");

        String s = jd.get("uid:4");

        System.out.println(s);
    }

    @Test
    public void testtime(){
        Jedis jedis=new Jedis("106.14.162.109",6379,5000);
        jedis.auth("lsx666");
    }

}
