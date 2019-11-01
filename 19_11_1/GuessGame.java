import java.util.Random;
import java.util.Scanner;

public class GuessGame{
	public static void main(String[] args){
		//猜数字游戏
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		System.out.println("欢迎进入猜数字游戏!");
		//times用来显示可以猜几次
		int times = 4;
		System.out.println("您有" + times +"次猜测的机会");
		System.out.println("正在生成数字，请稍后...");
		//生成一个随机数，最大值不超过100
		int n = random.nextInt(100);
		System.out.println("数字已生成，即将开始游戏!");
		//进行猜数字的判断，最多猜times次
		for(int i = 1; i <= times; i++){
			//输入要猜的数字
			int input = scanner.nextInt();
			//如果输入的数字与随机数相等，提醒玩家猜对了，返回
			if(input == n){
				System.out.println("恭喜您猜对了!");
				System.out.println("用了" + i + "次机会");
				return;
			}
			//如果输入的数字小于随机数，提醒玩家猜低了，并显示进行了几次猜测
			else if(input < n){
				System.out.println("第" + i + "次猜测，猜低了!");
			}
			//如果输入的数字大于随机数，提醒玩家猜高了，并显示进行了几次猜测
			else {
				System.out.println("第" + i + "次猜测，猜高了!");
			}
		}
		//如果循环结束都没有猜出来，提醒玩家游戏结束并显示正确的数字。
		System.out.println("很遗憾，Game Over!");
		System.out.println("正确的数字是:" + n);
	}
}