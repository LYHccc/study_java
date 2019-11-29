import java.util.Arrays;
import java.util.Scanner;
public class OperateProcess {
	public static void scannerToprint(Process[] p, int n){
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入进程的信息（进程名、到达时间、服务时间）:");
		for(int i = 0; i < n; i++){
			System.out.println("请输入第" + (i + 1) + "个进程信息");
			p[i] = new Process();
			System.out.print("进程名：");
			p[i].name = scanner.next();
			System.out.print("到达时间：");
			p[i].arriveTime = scanner.nextInt();
			System.out.print("服务时间：");
			p[i].serveTime = scanner.nextInt();
		}
	}
	public static void FCFS(Process[] p){
		p[0].finishTime = p[0].serveTime;
		p[0].roundTime = p[0].finishTime - p[0].arriveTime;
		p[0].weightTime = p[0].roundTime / p[0].serveTime;
		for(int i = 1; i < p.length; i++){
			p[i].finishTime = p[i - 1].finishTime + p[i].serveTime;
			p[i].roundTime = p[i].finishTime - p[i].arriveTime;
			p[i].weightTime = p[i].roundTime / p[i].serveTime;
		}
	}
	public static void printFCFS(Process[] p, int n){
		Arrays.sort(p);
		for(int i = 0; i < n; i++){
			System.out.println(p[i].toString());
		}
	}
}