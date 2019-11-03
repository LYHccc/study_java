public class Recursion{
	/*
	//递归求一个数字的每一位之和
	public static int sum(int n){
		if(n < 10){
			return n;
		}
		else{
			return sum(n / 10) + n % 10;
		}
	}
		public static void main(String[] args){
		System.out.println(sum(9527));
	}
	*/
	
	//汉诺塔问题
	public static void hanoi(int n, int from, int to){
		if(n == 1){
			System.out.printf("从%d移动到%d%n", from, to);
		}else{
			int other = 3 - from - to;
			hanoi(n - 1, from, other);
			System.out.printf("从%d移动到%d%n", from, other);
			hanoi(n - 1, other, to);
		}
	}
	public static void main(String[] args){
		hanoi(4, 0, 2);
	}
}