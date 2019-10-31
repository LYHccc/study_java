//输入[0，6]判断今天是星期几
public class SwitchDemo{
	public static void main(String[] args){
		//判断有没有输入数字，没有的话提醒输入一个数字
		if(args.length != 1){
			System.out.printf("请输入一个[0,6]的数字：%n");
			return;
		}
		int today = Integer.parseInt(args[0]);
		//用switch语句判断今天是星期几
		//输入0-6分别输出星期几，输入其他提示“输入错误，没有这个日子”
		switch(today){
			case 0:
			System.out.printf("今天是星期天%n");
			break;
			case 1:
			System.out.printf("今天是星期一%n");
			break;
			case 2:
			System.out.printf("今天是星期二%n");
			break;
			case 3:
			System.out.printf("今天是星期三%n");
			break;
			case 4:
			System.out.printf("今天是星期四%n");
			break;
			case 5:
			System.out.printf("今天是星期五%n");
			break;
			case 6:
			System.out.printf("今天是星期六%n");
			break;
			default:
			System.out.printf("输入错误，没有这个日子%n");
		}
	}
}