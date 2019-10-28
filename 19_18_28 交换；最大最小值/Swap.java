//给定两个int型变量，交换他们的值
public class Swap{
	public static void main(String[] args){
		int a_Swap = 1;
		int b_Swap = 2;
		//设置中间变量用来交换
		int t_Swap = a_Swap;
		a_Swap = b_Swap;
		b_Swap = t_Swap;
		System.out.println(a_Swap);
		System.out.println(b_Swap);
	}
}