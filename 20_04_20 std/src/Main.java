/*
wait()、notify()、notifyAll()演示
 */
class MyThread1 implements Runnable {
    private Object obj;

    public MyThread1( Object obj) {
        super();
        this.obj = obj;
    }

    @Override
    public void run() {
        synchronized (obj) {
            try {
                while (true) {
                    System.out.println("wait()方法开始.. " + Thread.currentThread().getName());
                    obj.wait();
                    System.out.println("wait()方法结束.. " + Thread.currentThread().getName());
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread2 implements Runnable{
    private Object obj;

    public MyThread2( Object obj) {
        super();
        this.obj = obj;
    }

    @Override
    public void run() {
        synchronized (obj) {
            try {
                System.out.println("notify()方法开始.. " + Thread.currentThread().getName());
                obj.notify();
                //obj.notifyAll();
                System.out.println("notify()方法结束.. " + Thread.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("notify同步代码块外");
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        MyThread1 waitThread1 = new MyThread1( object);
        //MyThread1 waitThread2 = new MyThread1( object);
        //MyThread1 waitThread3 = new MyThread1( object);
        MyThread2 notifyThread = new MyThread2(object);

        Thread thread1 = new Thread(waitThread1, "wait线程");
        //Thread thread2 = new Thread(waitThread2, "wait线程");
        //Thread thread3 = new Thread(waitThread3, "wait线程");
        Thread thread4 = new Thread(notifyThread, "notify线程");

        thread1.start();
        //thread2.start();
        //thread3.start();
        Thread.sleep(5000);
        thread4.start();
    }
}

