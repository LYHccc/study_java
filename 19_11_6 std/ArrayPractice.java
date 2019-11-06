import java.util.Arrays;
import java.util.Scanner;

public class  ArrayPractice{
	//冒泡排序（从左到右冒泡，升序排序）
	/*
	public static void bubbleSort(int[] a){
		int temp = 0;
		//外部循环实现冒泡的次数
		for(int i = 0; i < a.length - 1; i++){
			//内循环则是进行每次冒泡进行的冒泡操作，
			//从第一个元素开始，如果前一个元素大于后一个元素那么交换两个元素的值
			for(int j = 0; j < a.length - (i + 1); j++){
				if(a[j] > a[j + 1]){
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}
	public static void main(String[] args){
		int[] a ={5, 6, 3, 8, 2, 1};
		bubbleSort(a);
		System.out.println(Arrays.toString(a));
	}
	*/
	//二分查找
	public static int binarySearch(int[] a, int value){
		//定义一个左值为left下标为第一个元素下标
		//右值为right为最后一个元素下标
		int left = 0;
		int right = a.length - 1;
		//只要[left,right]之间还有数，继续查找
		while(left <= right){
			//定义中间值mid，中间元素的下标
			int mid = (left + right) / 2;
			//如果中间元素的值等于value说明找到了。
			//如果中间元素的值大于value，说明value在中间元素的左边，就让右值等于mid-1（因为mid已经进行了比较）
			//如果中间元素的值小于value，说明value在中间元素的右边，就让左值等于mid+1（因为mid已经进行了比较）
			if(value == a[mid]){
				return mid;
			}else if(value < a[mid]){
				right = mid - 1;
			}else{
				left = mid + 1;
			}
		}
		return -1;
	}
	public static void main(String[] args){
		int[] a ={1, 2, 3, 4, 5};
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		System.out.println(binarySearch(a, n));
	}
}