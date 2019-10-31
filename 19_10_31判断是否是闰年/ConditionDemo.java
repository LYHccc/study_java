//输入一个年份，判断是否是闰年
//判断是否是闰年闰年需要满足以下两种条件：
//1.能被4整除，但不能被100整除；
//2.能被400整除；
public class ConditionDemo{
	public static void main(String[] args){
		//判断是否输入了一个年份，如果没有显示“请输入一个年份”
		if(args.length != 1){
			System.out.printf("请输入一个年份:%n");
			return;
		}
		int year = Integer.parseInt(args[0]);
		//判读是否是闰年，是的话输出是闰年
		if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0) ){
			System.out.printf("是闰年%n");
		}
		//不是的话输出不是闰年
		else System.out.printf("不是闰年%n");
	}
}