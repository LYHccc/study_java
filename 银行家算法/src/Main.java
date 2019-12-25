import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RealizeArithmetic realize = new RealizeArithmetic();
        System.out.println("请输入资源种类数目：");
        Scanner scanner = new Scanner(System.in);
        int resourceNum = scanner.nextInt();
        realize.AvailableInit(resourceNum);                 //初始化可用资源

        System.out.println("请输入进程种类数目：");
        int processNum = scanner.nextInt();
        realize.AllocationInit(processNum, resourceNum);    //初始化已分配资源
        realize.NeedInit(processNum, resourceNum);          //初始化尚需资源
        realize.Safe();
        realize.print();                                    //打印初始化的结果

        while(true) {
            System.out.println("请输入需求分配的进程编号：");
            int numProcess = scanner.nextInt();
            List<Integer> request = new ArrayList<>();
            request = realize.requestScan();
            System.out.println("请求分配资源矩阵：");
            System.out.println(request);
            realize.requestAlloc(request, numProcess);
            realize.print();
        }
    }
}
