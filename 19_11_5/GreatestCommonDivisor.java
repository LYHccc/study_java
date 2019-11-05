import java.util.Scanner;

public class GreatestCommonDivisor{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		//输入两个正整数a,b
		System.out.println("请输入两个正整数!");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		//如果输入了负数请重新输入
		if(a < 0 || b < 0){
			System.out.println("请重新输入两个正整数!");
			return;
		}
		//定义min为两个整数中的较小数
		int min = a;
		if(a > b){
			min = b;
		}
		//将min从a和b中较小的开始递减，
		while(min > 0){
			//如果a和b同时被min整除结束循环，此时的min就是最大公约数
			if(a % min == 0 && b % min == 0)break;
			min--;
		}
		System.out.println("最大公约数为:" + min);
	}
}