package 使用java提供的方式停止通知;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyThrend myThrend = new MyThrend();
        myThrend.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        myThrend.interrupt();  // 主线程中通知 MyThread 线程停止
    }
}
