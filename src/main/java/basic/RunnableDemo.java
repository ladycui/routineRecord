package basic;

import java.util.Optional;

public class RunnableDemo {
    public static void main(String[] args) {
        IRunnable runnable = new IRunnable();
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        Thread t4 = new Thread(runnable);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class IRunnable implements Runnable {
    private int tickets = 10;
    private Object obj = new Object();

    public void run() {
        for (int i = 0; i < 50; i++) {
            synchronized (this) {
                /*sleep不释放锁，要在同步代码外睡觉，不然就一个线程一直执行；
                 * wait释放锁，若放在同步代码里面，要先操作，操作完后，再wait，释放锁*/
                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + "---" + tickets--);
                    try {
                        wait(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}