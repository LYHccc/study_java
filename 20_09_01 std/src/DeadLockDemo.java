public class DeadLockDemo {
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1){
                    try {
                        System.out.println(Thread.currentThread().getName() + "--lock1--");
                        Thread.sleep(3000);
                        synchronized (lock2) {
                            System.out.println(Thread.currentThread().getName() + "--lock2--");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock2){
                    System.out.println(Thread.currentThread().getName() + "--lock2--");
                    synchronized (lock1) {
                        System.out.println(Thread.currentThread().getName() + "--lock1--");
                    }
                }
            }
        });
        t1.start();
        t2.start();
        System.out.println(Thread.currentThread().getName());
    }
}
