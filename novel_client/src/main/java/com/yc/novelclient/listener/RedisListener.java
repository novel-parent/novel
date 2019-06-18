package com.yc.novelclient.listener;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

/**
 * @author LX
 * @date 2019/6/14 - 11:37
 */
@Component
public class RedisListener extends KeyExpirationEventMessageListener {

    final String userKey = "user:";

    public RedisListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    /**
     *
     *     进行redis 失效key 的监控
     * @param message
     * @param pattern
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {

        // 用户做自己的业务处理即可,注意message.toString()可以获取失效的key
        String expiredKey = message.toString();
        if(expiredKey.startsWith( userKey )){

            //如果是Order:开头的key，进行处理
            System.out.println(new String(message.getBody()));

            System.out.println(new String(pattern));
        }
    }
}
