/*
//判断素数
import java.util.Scanner;

public class Main{
	public static int judge(int num){
		for(int i = 2; i < num; i++){
			if((num % i) == 0){
				return 0;
			}
		}
		return 1;
	}
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int result = judge(n);
		if(result == 1){
			System.out.println("prime");
		}else{
			System.out.println("not prime");
		}
	}
}
*/


/*
//给出一个不多于5位的整数，要求 1、求出它是几位数 2、分别输出每一位数字 3、按逆序输出各位数字，例如原数为321,应输出123
import java.util.Scanner;

public class Main{
	//求这个数是几位数
	public static int Leng(int num){
		//num > 0的条件下用num除以十，每除一次表示一位 n + 1，直到除掉最后一位此时num = 0循环结束
		int n = 0;
		while(num > 0){
			num = num / 10;
			n++;
		}
		return n;
	}
	//输出每一位
	public static void output1(int num){
		//如果num > 9说明位数大于1位，则将n / 10（去掉最后一位）递归调用output1
		//如果num <= 9了说明就剩一位，num % 10输出这一位，并从堆栈中依次输出其他位数
		if(num > 9){
			output1(num / 10);
		}
		System.out.printf("%d ", num % 10);
	}
	//逆序输出每一位
	public static void output2(int num){
		//用num % 10来输出每一位，同时num / 10去掉最后一位
		int n = 0;
		while(num > 0){
			n = num % 10;
			num = num / 10;
			System.out.printf("%d", n);
		}
	}
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		System.out.println(Leng(num));
		output1(num);
		System.out.println();
		output2(num);
	}
}
*/



//输入两个正整数X,Y,求出[X,Y]内被除3余1并且被除5余3的整数的和
import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		//输入两个正整数
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		//找出两个整数中较大的和较小的
		int min = a;
		int max = b;
		if(min > max){
			int t = min;
			min = max;
			max = t;
		}
		//在两个整数的闭区间内对被3除余1与被5除余3的进行相加
		int sum = 0;
		for(int i = min; i <= max; i++){
			if((i % 3 == 1) && (i % 5 == 3)){
				sum += i;
			}
		}
		System.out.println(sum);
	}
}



