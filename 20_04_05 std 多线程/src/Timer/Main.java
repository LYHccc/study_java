package Timer;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class Main {
    private static class Task extends MyTimer.MyTimerTask {
        @Override
        public void run() {
            System.out.println("10s 已到");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyTimer timer = new MyTimer();
        timer.schedule(new Task(), 10 * 1000);

        while (true) {
            System.out.println("一直打印");
            TimeUnit.MILLISECONDS.sleep(1000);
        }
    }
}
