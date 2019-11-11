//给一个时间可以在这个时间的基础上加减相应的时间并输出结果
import java.util.Scanner;

public class MyTime{
	private int hour;
	private int minute;
	private int second;
	//构造方法，用于完成初始化
	//如果初始化的时候hour(时)超过23、分和秒 < 0或者 > 59提醒用户这是"不支持的参数"
	public MyTime(int hour, int minute, int second){
		if(hour > 23){
			System.out.println("不支持的时:");
			return;
		}
		if(minute < 0 || minute > 59){
			System.out.println("不支持的分:");
			return;
		}
		if(second < 0 || second > 59){
			System.out.println("不支持的秒:");
			return;
		}
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	@Override
	public String toString() {
		return String.format("%02d:%02d:%02d", hour, minute, second);
	}
	//在当前时间上加上seconds秒
	public void add(int seconds){
		second += seconds;           //在当前秒数上加上seconds秒
		while(second > 59){          //如果秒数超过59，说明需要向分钟产生进位
			second -= 60;            //产生一个进位秒数减去60
			minute += 1;             //产生一个进位分钟数加上1
			if(minute > 59){         //如果分钟超过59，说明需要向小时产生进位
				hour += 1;           //产生一个进位小时数加上1
				minute -= 60;        //产生一个进位分钟数减去60
				if(hour > 23){       //如果小时数超过23，则要将小时从零开始进行下一轮
				hour -= 24;
				}
			}
		}
	}
	//在当前时间上减少seconds秒
	//减去seconds秒跟加秒原理基本相同，只需在代码略加修改
	public void sub(int seconds){
		second -= seconds;
		while(second < 0){
			second += 60;
			minute -= 1;
			if(minute < 0){
				hour -= 1;
				minute += 60;
				if(hour < 0){
				hour += 24;
				}
			}
		}
	}

	public static void main(String[] args){
		//用户输入此刻的时、分、秒
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入时:");
		int hour = scanner.nextInt();
		System.out.println("请输入分:");
		int minute = scanner.nextInt();
		System.out.println("请输入秒:");
		int seconds = scanner.nextInt();
		//调用构造方法MyTime对时、分、秒初始化
		MyTime time = new MyTime(hour, minute, seconds);
		System.out.println(time);
		//用户输入选择加还是减
		//选择后输入要加减的时间
		System.out.println("请输入1(代表加)或者输入0(代表减)");
		int select = scanner.nextInt();
		if(select == 1){
			System.out.println("输入要加的时间:");
			int up = scanner.nextInt();
			time.add(up);
			System.out.println(time);
		}else if(select == 0){
			System.out.println("请输入要减的时间:");
			int down = scanner.nextInt();
			time.sub(down);
			System.out.println(time);
		}else{
			System.out.println("输入有误!");
		}
	}
}




