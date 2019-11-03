import java.util.Arrays;

public class ArrayStudy{
	//返回数组中的最大值
	public static int MaxNum(int[] arr){
		int max = arr[0];
		for(int i = 0; i < arr.length; i++){
			if(max < arr[i]){
				max = arr[i];
			}
		}
		return max;
	}
	//返回数组和的平均值
	public static double average(int[] arr){
		double sum = 0.0;
		for(int i = 0; i < arr.length; i++){
			sum += arr[i];
		}
		return sum / arr.length;
	}
	//给定一个数字，从数组中找到第一次出现这个数的下标，找不到返回-1
	public static int indexOf(int[] arr, int n){
		int i = 0;
		for(i = 0; i < arr.length; i++){
			if(n == arr[i]){
				return i;
			}
		}
		return -1;
	}
	//给定一个数字，从数组中找到最后一次出现这个数的下标，找不到返回-1
	public static int lastlndexof(int[] arr, int n){
		int i = 0;
		for(i = arr.length - 1; i >= 0; i--){
			if(n == arr[i]){
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args){
		int[] arr = {1, 2, 5, 8, 6, 5, 6};
		int n = Integer.parseInt(args[0]);
		System.out.println(MaxNum(arr));
		System.out.println(average(arr));
		System.out.println(indexOf(arr, n));
		System.out.println(lastlndexof(arr, n));
	}
}