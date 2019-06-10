import org.junit.Test;
import redis.clients.jedis.Jedis;
import service.UserService;
import service.impl.UserServiceImpl;

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
        Jedis jd=new Jedis("106.14.162.109",6379,50000);
        jd.auth("lsx666");

        if(jd.exists("xxx")){
            System.out.println(jd.get("xxx"));
            jd.del("xxx");
        }
     //   jd.set("xxx","lisi");

    }

}
