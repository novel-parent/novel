package com.yc.novelclient.listener;

import com.yc.novelclient.bean.User;
import com.yc.thrift.client.NovelThriftClient;
import com.yc.util.FreeClientUtil;
import org.apache.thrift.transport.TTransportException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * @author LX
 * @date 2019/6/14 - 10:37
 */
//@Component
public class RabbitMqLister {

    /**
     *  在此监控  消息中间件 中 user.queue队列  中的消息
     * @param user
     */
    @RabbitListener(queues = "user.queue")
    public void login(User user){

        if (user.getVip() == null){
            // 普通用户登录
        }else{
            String  uid = user.getUid() + "";
            //  vip 用户登录
            NovelThriftClient client = null;
            try {
                client = FreeClientUtil.freeStack.pop();

            } catch (Exception e) {

                /**
                 *    栈里面没有了
                 */
                try {

                    client = new NovelThriftClient();
                } catch (TTransportException e1) {

                    e1.printStackTrace();
                }

                e.printStackTrace();
            }

//            VipUtil.vipUserThriftClientHashMap.put(uid, client);
        }
        System.out.println(user);
    }
}
