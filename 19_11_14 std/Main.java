//编写一个类Calculator,有两个属性num1,num2,这两个数据的值，不能在定义的同时初始化，最后实现加减乘除四种运算.
class Calculator{
	//定义属性
	private int num1;
	private int num2;
	//构造方法初始化num1,num2
	public Calculator(int num1, int num2){
		this.num1 = num1;
		this.num2 = num2;
	}
	//相加
	public int add(){
		int value = num1 + num2;
		return value;
	}
	//相减
	public int sub(){
		int value = num1 - num2;
		return value;
	}
	//相乘
	public int ride(){
		int value = num1 * num2;
		return value;
	}
	//相除
	public double divide(){
		double value = (double)num1 / num2;
		return value;
	}
}
public class Main{
	public static void main(String[] args){
		Calculator cal = new Calculator(5, 2);
		System.out.println(cal.add());
		System.out.println(cal.sub());
		System.out.println(cal.ride());
		System.out.println(cal.divide());
	}
}