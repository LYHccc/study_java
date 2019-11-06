import java.util.Arrays;
import java.util.Scanner;

public class ArrayCopy{
	public static int[] copyOf(int[] a, int newLength){
		//定义一个新数组用来存放拷贝到的数，数组长度等于用户要拷贝的长度
		int[] b = new int[newLength];
		//定义min使其等于数组a[]的长度和要拷贝的长度两者之间的较小值
		int min = newLength;
		if(newLength > a.length){
			min = a.length;
		}
		//进行拷贝
		for(int i = 0; i < min; i++){
			b[i] = a[i];
		}
		return b;
	}
	public static void main(String[] args){
		int[] a = {1, 2, 3, 4, 5};
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		System.out.println(Arrays.toString(copyOf(a, n)));
	}
}