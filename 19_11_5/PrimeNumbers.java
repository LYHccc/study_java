import java.util.Scanner;

public class PrimeNumbers{
	//定义一个方法用来判断是不是素数
	public static int Distinguish(int n){
		//从2开始到n-1，如果n能被整除，说明不是素数返回0，否则返回1
		for(int i = 2; i < n; i++){
			if(n % i == 0){
				return 0;
			}
		}
		return 1;
	}
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		//n<=1不是素数，
		if(n <= 1){
			System.out.println("不是素数");
			return;
		}
		//在n>1的条件下调用方法，返回值是1打印"是素数"，反之打印"不是素数"
		else if(Distinguish(n) == 1){
			System.out.println("是素数");
		}else{
			System.out.println("不是素数");
		}
	}
}