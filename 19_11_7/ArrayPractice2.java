import java.util.Arrays;
import java.util.Scanner;

public class  ArrayPractice2{
	//将指定数组的指定范围复制到新数组中
	public static int[] copyOfRange(int[] a, int from, int to){
		int[] b = new int[to - from];
		for(int i = from; i < to; i++){
			b[i - from] = a[i];
		}
		return b;
	}
	//将指定的int值分配给指定的int数组的每个元素。
	public static void fill(int[] a, int val){
		for(int i = 0; i < a.length; i++){
			a[i] = val;
		}
	}
	//将指定的int值分配给指定的int数组的指定范围的每个元素。
	public static void fill(int[] a, int from, int to, int val){
		for(int i = from; i < to; i++){
			a[i] = val;
		}
	}
	//如果两个指定的int数组彼此相等,则返回 true 
	public static boolean equals(int[] a, int[] b){
		if(a.length != b.length){
			return false;
		}
		for(int i = 0; i < a.length; i++){
			if(a[i] != b[i]){
				return false;
			}
		}
		return true;
	}
	//将指定源数组中的数组从指定位置复制到目标数组的指定位置。
	public static void arraycopy(int[] src, int srcPos, int[] dest, int destPos, int length){
		//src和dest是否指向同一个数组对象
		if(src == dest){
			int[] temArray = copyOfRange(src,srcPos,srcPos + length);
			for(int i = 0; i < length; i++){
				dest[destPos + i] = temArray[i];
			}
		}else{
			for(int i = 0; i <length; i++){
				dest[destPos + i] = src[srcPos + i];
			}
		}
	}
	public static void main(String[] args){
		int[] a = {1, 5, 4, 2, 9, 8, 6, 3};
		int[] b = {1, 5, 4, 2, 9, 8, 6, 3};
		int[] c = {1, 5, 4, 2, 9, 8, 6, 3};
		int[] d = {1, 5, 4, 2, 9, 8, 6, 3};
		System.out.println(Arrays.toString(copyOfRange(a, 1, 6)));
		fill(a, 7);
		System.out.println(Arrays.toString(a));
		fill(b, 1, 6, 5);
		System.out.println(Arrays.toString(b));
		System.out.println(equals(c,d));
	}
}