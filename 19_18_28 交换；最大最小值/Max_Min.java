//给定三个int变量，求其中最大值和最小值
public class Max_Min{
	public static void main(String[] args){
		//如果没有输入三个整数提示应输入三个整数
		if(args.length != 3){
			System.out.println("请输入三个整数");
			return;
		}
		//定义最大值和最小值都为为第一个元素
		int Max = Integer.parseInt(args[0]);
		int Min = Integer.parseInt(args[0]);
		//循环进行判断
		for(int i = 1;i < args.length ; i++){
			//如果大于Max将值赋给Max
			if(Integer.parseInt(args[i]) > Max){
				Max = Integer.parseInt(args[i]);
			}
			//如果小于Min将值赋给Min
			if(Integer.parseInt(args[i]) < Min){
				Min = Integer.parseInt(args[i]);
			}
		}
		System.out.println("Max = " + Max);
		System.out.println("Min = " + Min);
	}
}