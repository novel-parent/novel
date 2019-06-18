package com.yc.util;

import com.yc.thrift.client.UserThriftClient;

import java.util.Stack;

/**
 * @author LX
 * @date 2019/6/18 - 18:02
 */
public class FreeClientUtil {

    public static Stack<UserThriftClient> freeStack = new Stack<>();
    {
        UserThriftClient [] userThriftClient = new UserThriftClient[10] ;
    }
}
