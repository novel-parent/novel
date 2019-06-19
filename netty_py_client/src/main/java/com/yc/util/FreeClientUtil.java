package com.yc.util;

import com.yc.thrift.client.NovelThriftClient;
import org.apache.thrift.transport.TTransportException;

import java.util.Stack;

/**
 * @author LX
 * @date 2019/6/18 - 18:02
 */
public class FreeClientUtil {

    public static Stack<NovelThriftClient> freeStack = new Stack<>();

    static{
        int number = 10 ;
        for (int i = 0; i< number ;i++ ){

            try {

                freeStack.push(new NovelThriftClient());
            } catch (TTransportException e) {

                e.printStackTrace();
            }
        }

    }
}
