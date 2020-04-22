package basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 此例说明，当类锁被锁住时，不影响对象锁的使用
 *
 * e1开启，e2开启，e2的结果穿插在e1中
 */
public class SynchronizedExample {

    public void func2() {
        synchronized (SynchronizedExample.class) {
            for (int i = 0; i < 10; i++) {
                System.out.println(i + " " + " locked by class");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void synchroMethod() {
        System.out.println("this is a synchronised method, locked by object");
    }

    public static void main(String[] args) {
        SynchronizedExample e1 = new SynchronizedExample();
        SynchronizedExample e2 = new SynchronizedExample();

        ExecutorService threadPool = Executors.newCachedThreadPool();
        threadPool.execute(() -> e1.func2());
        threadPool.execute(() -> e2.synchroMethod());

        threadPool.shutdown();

    }
}