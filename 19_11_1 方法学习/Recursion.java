public class Recursion{
	/*
	public static int fac(int n){
		if(n == 1){
			return 1;
		}else{
			return n * fac(n - 1);
		}
	}
	*/
	public static int fibonacci(int n){
		if(n == 0 || n == 1){
			return 1;
		}
		else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}
	public static void main(String[] args){
		//int n = Integer.parseInt(args[0]);
		//System.out.println(fac(n));
		int n = Integer.parseInt(args[0]);
		for(int i = 0; i <= n; i++){
			System.out.println(fibonacci(i));
		}
	}
}