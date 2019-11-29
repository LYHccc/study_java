import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		System.out.println("请输入进程数量：");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Process[] p = new Process[n];
		OperateProcess p1 = new OperateProcess();
		p1.scannerToprint(p, n);
		p1.FCFS(p);
		p1.printFCFS(p, n);
	}
}
