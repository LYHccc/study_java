//设圆半径r，圆柱高h 求圆周长C1、圆面积Sa、圆球表面积Sb、
//圆球体积Va、圆柱体积Vb。 用scanf输入数据，输出计算结果，
//输出时要求文字说明，取小数点后两位数字。请编程序。 PI＝3.14
import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		double r = scanner.nextDouble();
		double h = scanner.nextDouble();
		double PI = 3.14;
		double C1 = 0.0;
		double Sa = 0.0;
		double Sb = 0.0;
		double Va = 0.0;
		double Vb = 0.0;
		C1 = 2 * PI * r;
		Sa = PI * r * r;
		Sb = 4 * PI * r * r;
		Va = 4.0 / 3.0 * PI * r * r * r;
		Vb = PI * r * r * h;
		System.out.printf("C1=%2.2f%n", C1);
		System.out.printf("Sa=%2.2f%n", Sa);
		System.out.printf("Sb=%2.2f%n", Sb);
		System.out.printf("Va=%2.2f%n", Va);
		System.out.printf("Vb=%2.2f%n", Vb);
	}
}



