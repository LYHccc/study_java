import java.util.Scanner;

public class MethodDemo{
	/*
	public static double sub(double a, double b){
		return a - b;
	}
	*/
	
	public static int fac(int n){
		int num = 1;
		for(int i = 1; i <= n; i++){
			num *= i;
		}
		return num;
	}
	public static void main(String[] args){
		/*
		double a = 2.2;
		double b = 1.1;
		double r = sub(a, b);
		System.out.println(r);
		*/
		
		//int n = Integer.parseInt(args[0]);
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int sum = 0;
		for(int i = 1; i <= n; i++){
			sum += fac(i);
		}
		System.out.println(sum);
	}
}