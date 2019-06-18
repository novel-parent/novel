package com.yc.novelclient.listener;

import com.yc.novelclient.bean.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

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



        System.out.println(user);
    }
}
