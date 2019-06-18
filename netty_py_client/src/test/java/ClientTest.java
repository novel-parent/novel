import com.yc.thrift.client.UserThriftClient;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransportException;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author LX
 * @date 2019/6/18 - 18:06
 */
public class ClientTest {

    /**
     *  15608564    41778
     *  15608564    60894
     *
     * 1560856362672
     * @throws TException
     */
    @Test
    public void test() throws TException {


        AtomicInteger j = new AtomicInteger();
        System.out.println("haskfkasndf    "+System.currentTimeMillis());
        for(int i =0;i<1000;i++){

            new Thread(()->{

                UserThriftClient userThriftClient = null;
                try {
                    userThriftClient = new UserThriftClient();
                } catch (TTransportException e) {
                    e.printStackTrace();
                }

                try {
                    System.out.println(userThriftClient.getNovelChapterListByNovelUrl("https://www.biqukan.cc/book/45226/"));
                } catch (TException e) {
                    e.printStackTrace();
                }

                userThriftClient.getTransport().close();
//            System.out.println(userThriftClient.getNovelChapterContextByChapterUrl("https://www.biqukan.cc/book/45226/"+26183909+".html").getNextChapter());

                System.out.println(j.incrementAndGet() +"  j  "+ (System.currentTimeMillis()));
            }).start();
        }

        try {
            Thread.sleep(500000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
