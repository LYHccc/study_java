//给定一个年月日可以在这个日子的基础上进行加减相应的天数并输出
import java.util.Scanner;

public class MyDate{
	//定义属性年、月、日
	private int year;
	private int month;
	private int day;
	//创建一个数组DAY_OF_MONTH用来存放每个月有多少天第month月的天数为数组中[month - 1]的值
	public static final int[] DAY_OF_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	//定义方法给一个年份判断这一年是不是闰年
	public boolean isLeapYear(int year){
		if(year % 400 == 0){
			return true;
		}
		if(year % 4 == 0){
			if(year % 100 != 0){
				return true;
			}
		}
		return false;
	}
	//定义一个方法，给一个具体的年份及月份返回这这一年这个月有多少天
	//如果不是二月返回的天数就是数组DAY_OF_MONTH中的值
	//如果是二月判断这一年是不是闰年，如果是返回这个二月是29天，如果不是闰年返回这个二月是28天
	public int getDayOfMonth(int year, int month){
		if(month != 2){
			return DAY_OF_MONTH[month - 1];
		}else if(isLeapYear(year)){
			return 29;
		}else{
			return 28;
		}
	}
	//构造方法，对年、月、日初始化，初始化年月日必须符合现实的年月日天数的规定
	//我们假定年份只能取[1970,2030]之间、月份是固定的[1,12]月、
	//天数不能小于零、不能大于这一年这一月的具体天数(调用gerDayOfMonth来确定)
	public MyDate(int year, int month, int day){
		if(year < 1970 || year > 2030){
			System.out.println("不支持的年份");
			return;
		}
		if(month < 1 || month > 12){
			System.out.println("不支持的月数");
			return;
		}
		if(day < 1 || day > getDayOfMonth(year, month)){
			System.out.println("不支持的天数");
			return;
		}
		this.year = year;
		this.month = month;
		this.day = day;
	}
	@Override
	public String toString() {
		return String.format("%04d-%02d-%02d", year, month, day);
	}
	//在当前时间加上相应的天数
	public void add(int days){
		day += days;                                      //在当前的日子上加上days天
		while(day > getDayOfMonth(year, month)){          //如果天数超过了这一年这个月的天数，说明需要向下个月进位
			day -= getDayOfMonth(year, month);            //在当前的天数上减去这一年这个月的天数，进入下个月
			month += 1;                                   //进入下个月，月数加1
			if(month > 12){                               //如果月数超过了12，则向下一年进位
				year += 1;                                //进入下一年，年数加1
				month -= 12;                              //将月数置回1月，即减去12
			}
		}
	}
	//在当前时间退后相应的天数
	public void sub(int days){                            
		day -= days;                                      //在当前的日子上退后days天
		while(day < 1){                                   //如果天数小于了1，说明需要向上一月借位
			month -= 1;  								  //进入上个月，月数减1
			if(month < 1){                                //如果月数小于1了，需要向上一年借位
				year -= 1;                                //进入上一年，年数减1
				month += 12;                              //将月数置回12月，即加上12
			}
			day += getDayOfMonth(year, month);           //在当前的天数上向上个月借位即加上上个月对应的天数（因为上边对month-1，所以此时getDayOfMonth(year, month)对应的就是上个月的天数）
		}
	}
	
	
	public static void main(String[] args){
		//用户输入初始的年、月、日
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入年:");
		int year = scanner.nextInt();
		System.out.println("请输入月:");
		int month = scanner.nextInt();
		System.out.println("请输入日:");
		int day = scanner.nextInt();
		//调用构造方法MyDate对时、分、秒初始化
		MyDate date = new MyDate(year, month, day);
		System.out.println(date);
		//用户输入选择加还是减
		//选择后输入要加减的天数
		System.out.println("请输入1(代表加)或者输入0(代表减)");
		int select = scanner.nextInt();
		if(select == 1){
			System.out.println("输入要加的天数:");
			int up = scanner.nextInt();
			date.add(up);
			System.out.println(date);
		}else if(select == 0){
			System.out.println("请输入要减的天数:");
			int down = scanner.nextInt();
			date.sub(down);
			System.out.println(date);
		}else{
			System.out.println("输入有误!");
		}
	}
}

