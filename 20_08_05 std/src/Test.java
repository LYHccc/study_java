public class Test {
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();
    static class A extends Thread{
        @Override
        public void run() {
            synchronized (lock1){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println(Thread.currentThread().getName() + "A");
                }
            }
        }
    }

    static class B extends Thread{
        @Override
        public void run() {
            synchronized (lock2){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1){
                    System.out.println(Thread.currentThread().getName() + "B");
                }
            }
        }
    }

    public static void main(String[] args) {
        new A().start();
        new B().start();
    }
}
