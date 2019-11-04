import java.util.Scanner;

public class AgeJudgment{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一个年龄");
		//输入一个n作为年龄
		int n = scanner.nextInt();
		//如果输入的年龄小于0，提示重新输入
		if(n < 0){
			System.out.println("输入有误!请重新输入:");
			return;
		}
		//进行年龄判断，打印当前年龄的人是少年（小于18）、青年(19-28)、中年（29-55）、老年（56以上）。
		if(n <= 18){
			System.out.println("是少年");
		}else if(n >= 19 && n <= 28){
			System.out.println("是青年");
		}else if(n >= 29 && n <= 55){
			System.out.println("是中年");
		}else {
			System.out.println("是老年");
		}
	}
}