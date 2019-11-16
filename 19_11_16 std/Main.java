/*
//给出一百分制成绩，要求输出成绩等级‘A’、‘B’、‘C’、‘D’、‘E’。 
//90分以上为A 80-89分为B 70-79分为C 60-69分为D 60分以下为E
import java.util.Scanner;

public class Main{
	public static void main(String[] args){
			Scanner scanner = new Scanner(System.in);
			int score = scanner.nextInt();
			if(score < 0 || score >100){
				return;
			}
			if(score >= 90){
				System.out.println("A");
			}else if(score >= 80 && score <= 89){
				System.out.println("B");
			}else if(score >= 70 && score <= 79){
				System.out.println("C");
			}else if(score >= 60 && score <= 69){
				System.out.println("D");
			}else {
				System.out.println("E");
			}
	}
}
*/


//写一个函数，使给定的一个二维数组（３×３）转置，即行列互换。
import java.util.Scanner;

public class Main{
	//转置数组
	public static int[][] transpose(int[][] a){
		//定义一个新的数组b数组行数与数组a一样
		int[][] b = new int[a.length][];
		//将数组a每一行所对应的列长度赋值给数组b的行长度
		for(int i = 0; i < a.length; i++){
			b[i] = new int[a[i].length];
		}
		//将数组转置，将数组a每一列对应的值赋给数组b的每一行对应的元素
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < a[i].length; j++){
				b[i][j] = a[j][i];
			}
		}
		return b;
	}
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int[][] a = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};
		//调用方法transpose()转置数组a，并打印这个数组。
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < a[i].length; j++){
				System.out.printf("%d\t", transpose(a)[i][j]);
			}
			System.out.println();
		}
	}
}

