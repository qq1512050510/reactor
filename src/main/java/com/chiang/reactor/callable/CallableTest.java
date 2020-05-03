package com.chiang.reactor.callable;

import lombok.SneakyThrows;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(18);
        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(3000);
                System.out.println("call方法执行了" + getStringDate());
                return "call方法返回值";
            }
        };
        System.out.println("提交任务之前:" + getStringDate());
        Future<Object> future = threadPool.submit(callable);
        System.out.println("提交任务之后，获取结果之前：" + getStringDate());
        Thread.sleep(4000);
        System.out.println("获取返回值：" + future.get() + getStringDate());
        System.out.println("获取到结果之后：" + getStringDate());



        Runnable myRunnable = new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName() + " Run Times:" + getStringDate());
            }
        };
        String test = "";
        Future future1 = threadPool.submit(myRunnable);
        System.out.println(future1.get());
        System.out.println(test);

        Callable callable1 = new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println(Thread.currentThread().getName()+"开始休眠："+getStringDate());
                Thread.sleep(5000);
                return null;
            }
        };
        Future future2 = threadPool.submit(callable1);
        System.out.println("开始拿到结果：");
        try {
            System.out.println(future2.get(5000,TimeUnit.MILLISECONDS)+"获取结果"+getStringDate());
        } catch (TimeoutException e) {
            e.printStackTrace();
            System.out.println("获取结果超时");
        }

    }

    public static String getStringDate() {
        Date currentTime = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String dateString = simpleDateFormat.format(currentTime);
        return dateString;
    }
}
