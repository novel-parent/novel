import com.yc.loginregister.util.HttpUtil;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author LX
 * @date 2019/7/18 - 12:41
 */
public class HttpTest {

    @Test
    public void test1(){

        try {
            CloseableHttpResponse get = HttpUtil.Get("http://47.106.110.16/novelChapters.n?nid=14655");

            InputStream inputStream = get.getEntity().getContent();

            byte [] b = new byte[1024];
            int length ;

            StringBuffer stringBuffer = new StringBuffer();

            while ((length = inputStream.read(b))!=-1){

                stringBuffer.append(new String(b,0,length,"utf-8"));
            }

            String title = stringBuffer.toString().substring(stringBuffer.toString().lastIndexOf("title"));

            title = title.replace("\"", "").replace("\\", "").replace("}", "").replace("]", "").replace(" ", "").replace(":","," );

            String[] strings = title.split(",");

            System.out.println(strings[0]+" "+strings[1]+" "+strings[2]+" "+strings[3]);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
