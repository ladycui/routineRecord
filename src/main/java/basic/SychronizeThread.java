package basic;

/*
 * 代码中没有实现ReentrantLock用法，在需要加锁时lock.lock();解锁时lock.unlock(),放在finally中
 * */
public class SychronizeThread {
    public static void main(String[] args) {
        TicketsRunnable runnable = new TicketsRunnable();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class TicketsRunnable implements Runnable {
    private int tickets = 30;
    private Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            /*同步代码块*/
            synchronized (obj) {
                if (tickets > 0) {
                    /*sleep是抱着锁睡觉，不释放锁；wait释放锁
                     * 若把sleep放在同步块中，只有单线程执行run，所以要把sleep放在同步代码外*/
//                    try {
//                        Thread.sleep(200);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println(Thread.currentThread().getName() + " 卖出第" + tickets-- + "张票");
                }
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            /*同步方法*/
//            method();
        }
    }

    private synchronized void method() {
        if (tickets > 0) {
            System.out.println(Thread.currentThread().getName() + " 卖出第" + tickets-- + "张票");
        }
    }

}
