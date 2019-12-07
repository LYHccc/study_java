import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("内存分区块数：");
        int n = scanner.nextInt();
        System.out.println("第1块分区大小:");
        int size = scanner.nextInt();
        System.out.println("第1块分区起始地址:");
        int site = scanner.nextInt();
        Memory m = new Memory(size, site);

        for(int i = 1; i < n; i++) {
            System.out.println("第" + (i + 1) + "块分区大小");
            int mSize = scanner.nextInt();
            System.out.println("第" + (i + 1) + "块分区起始地址:");
            int mSite = scanner.nextInt();
            m.InIt(mSize, mSite);
        }
        m.printMemory();

        Process p = new Process();
        while(true) {
            System.out.println("请输入一个进程：");
            //System.out.println("进程名：");
            //p.name = scanner.nextLine();
            System.out.println("进程大小：");
            p.size = scanner.nextInt();
            System.out.println("1.首次适应算法FF");
            System.out.println("2.循环首次适应算法NF");
            System.out.println("3.最佳适应算法BF");
            System.out.println("4.最坏适应算法WF");
            System.out.println("请输入您的选择");
            int select = scanner.nextInt();
            switch (select) {
                case 1:
                    m.fristFit(p);
                    m.printMemory();
                    break;
                case 2:
                    m.nextFit(p);
                    m.printMemory();
                    break;
                case 3:
                    m.bestFit(p);
                    m.printMemory();
                    break;
                case 4:
                    m.worstFit(p);
                    m.printMemory();
                    break;
            }
        }
    }
}
