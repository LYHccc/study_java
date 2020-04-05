//多生产者多消费者
package 阻塞队列;
import java.util.Random;

public class ManyToMany {
    private static CirclationQueue queue = new CirclationQueue();

    private static class 生产者 extends Thread {
        生产者() {
            super("生产者");
        }

        @Override
        public void run() {
            Random random = new Random(20200405);
            try {
                while (true) {
                    queue.put(random.nextInt(200));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class 消费者 extends Thread {
        消费者() {
            super("消费者");
        }

        @Override
        public void run() {
            try {
                while (true) {
                    queue.take();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new 生产者().start();
        }

        for (int i = 0; i < 2; i++) {
            new 消费者().start();
        }
    }
}
