package basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
 *
 *
 * */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        /*单线程*/
//        ExecutorService service = Executors.newSingleThreadExecutor();
        /*固定数量*/
        ExecutorService service = Executors.newFixedThreadPool(2);
        /*可缓存的线程池，即当线程池大小超过任务所需线程时，会回收部分空闲线程（60秒不执行任务)，当任务数增加时，线程池会增加新线程
         * 大小没有限制，操作系统或jvm决定*/
//        ExecutorService service = Executors.newCachedThreadPool();


        service.execute(new ThreadPoolRunnable());
        service.execute(new ThreadPoolRunnable());
        /*延迟一定时间后创建线程*/
//        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
//        service.schedule(new ThreadPoolRunnable(), 30, TimeUnit.MILLISECONDS);

        service.shutdown();
    }
}

class ThreadPoolRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "....");
        }
    }
}