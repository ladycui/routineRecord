package basic;
/*
 * sleep()： 运行->阻塞
 * join(): 等待此线程死亡
 * */

public class ThreadDemo {
    public static void main(String[] args) {
//        MyThread thread1 = new MyThread();
//        thread1.start();

        MyRunnable runnable = new MyRunnable();
        Thread thread2 = new Thread(runnable);
        thread2.start();

        Thread thread4 = new Thread(runnable);
        thread4.start();

//        MyRunnable3 runnable3 = new MyRunnable3();
//        Thread thread3 = new Thread(runnable3);
        /*在start前setDaemon*/
//        thread3.setDaemon(true);//设置为守护线程；当用户线程都执行完毕后，jvm退出，即守护线程停止；e.g.下载软件的下载任务可以设置为守护线程，当用户关闭程序时，下载线程停止
//        thread3.start();

//        for(int i = 0; i < 50; i++){
//            System.out.println(Thread.currentThread().getName() + i);
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            if(i == 20){
//                try {
//                    thread3.join(); //让thread3先执行，执行完了，当前线程再执行
////                    Thread.yield(); //当前线程让出cpu一次
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

    }
}

class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "--" + i);
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "--" + i);
            try {
                Thread.sleep(1);    //sleep(1) is wrong, it must be "Thread.sleep"
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyRunnable3 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "--" + i);
            try {
                Thread.sleep(1);    //sleep(1) is wrong, it must be "Thread.sleep"
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

