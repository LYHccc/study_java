/**
 * 两个线程轮流打印1-100
 */
public class Main {
    private static int count = 1;
    private static Object lock = new Object();

    static class MyRunnable implements Runnable{
        @Override
        public void run() {
            try {
                synchronized (lock){
                    while (count <= 100) {
                        System.out.println(Thread.currentThread().getName() + "--" + count++);
                        lock.notify();
                        if(count < 100) {
                            lock.wait();
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable());
        Thread t2 = new Thread(new MyRunnable());
        t1.start();
        t2.start();
    }
}
