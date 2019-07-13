package com.yc.novelclient.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author LX
 * @date 2019/5/21 - 21:16
 */
public class ThreadPollUtil {

    public static ExecutorService executorService =
            Executors.newFixedThreadPool(20);

}
