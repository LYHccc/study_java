import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入进程数量：");
        int n = scanner.nextInt();
        Process[] p = new Process[n];
        processMenu pm=new processMenu();
        pm.init(p, n);//初始化容器
        System.out.println("1.FCFS算法");
        System.out.println("2.SJF算法");
        System.out.println("3.RR算法");
        while(true) {
            System.out.println("请输入您的选择：");
            int select = scanner.nextInt();
            switch (select) {
                case 1:
                    pm.FCFS();
                    pm.printProcess();
                    break;
                case 2:
                    pm.SJF();
                    pm.printProcess();
                    break;
                case 3:
                    System.out.println("时间片q");
                    int q = scanner.nextInt();
                    pm.RR(q);
                    pm.printProcess();
                    break;
            }
        }
    }
}
