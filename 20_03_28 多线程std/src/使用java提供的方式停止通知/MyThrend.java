package 使用java提供的方式停止通知;

import java.util.concurrent.TimeUnit;

public class MyThrend extends Thread {
    @Override
    public void run() {
        //MyThread线程判断是否有人让自己停止
        while(Thread.interrupted() == false){
            try {
                System.out.println("工作");
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                System.out.println(e);

                break;//停止线程，即退出循环
            }
        }
    }
}
