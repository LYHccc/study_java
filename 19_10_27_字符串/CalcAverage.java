public class CalcAverage{
	public static void main(String[] args){
		if(args.length == 0)
		{
			System.out.println("输入错误！请至少输入一个数字");
			return;
		}	
		int sum = 0;
		for(int i = 0; i < args.length; i++){
			sum += Integer.parseInt(args[i]);
		}
		double aver = 1.0 * sum / args.length;
		System.out.println("平均值为:" + aver);
	}
}