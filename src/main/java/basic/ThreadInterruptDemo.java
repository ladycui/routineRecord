package basic;

/*
 * 推荐使用自定义中断,即在runnable中设置一个flag
 * */
public class ThreadInterruptDemo {
    public static void main(String[] args) {

        InterruptRunnable runnable = new InterruptRunnable();
        Thread thread = new Thread(runnable);
        thread.start();

        InterruptRunnable2 runnable2 = new InterruptRunnable2();
        Thread thread2 = new Thread(runnable2);
        thread2.start();

        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "--" + i);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == 20) {
                thread.interrupt(); //通知thread，让其interrupt，但具体是否会interrupt由thread自己决定
                System.out.println(thread.isInterrupted());//true

                runnable2.flag = false;
            }
        }
        System.out.println(thread.isInterrupted());//false

    }
}

class InterruptRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            if (Thread.interrupted())//返回当前线程中断标记，并清除标记
                break;
            System.out.println(Thread.currentThread().getName() + "--" + i);
            try {
                Thread.sleep(1);//若线程在sleep中被中断，抛出“sleep interrupted”异常，并清除异常
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt(); //sleep抛出异常后，清除中断标记，此时要再添加中断标记
            }
        }
    }
}

class InterruptRunnable2 implements Runnable {

    public boolean flag;

    public InterruptRunnable2() {
        this.flag = true;
    }

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "--" + i++);
        }

    }
}