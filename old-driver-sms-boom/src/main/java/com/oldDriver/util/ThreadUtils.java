package com.oldDriver.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 
 * 

 * @Description:线程池工具类

 * @author:lixin

 * @time:2016年8月31日 上午11:44:28
 */
public class ThreadUtils {
    public static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();
    private ThreadUtils(){}
}
