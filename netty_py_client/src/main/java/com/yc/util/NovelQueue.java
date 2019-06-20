package com.yc.util;

import com.yc.thrift.client.NovelThriftClient;
import org.apache.thrift.transport.TTransportException;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author LX
 * @date 2019/6/19 - 16:19
 */
public class NovelQueue {

    public static BlockingQueue<NovelThriftClient> novelThriftClientQueue = new ArrayBlockingQueue<>(10);

    static {

        int number = 10 ;

        for (int i =0 ;i< number ; i++){

            try {

                novelThriftClientQueue.add(new NovelThriftClient());
            } catch (TTransportException e) {

                e.printStackTrace();
            }
        }
    }
}
