//快速排序的实现(递归实现)
import java.util.Arrays;

public class QuickSort {
    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    //快速排序一次排序过程
    public static int quick(int[] arr, int left, int right){
        //保留基准值
        int value = arr[left];
        //基准值所在下表
        int start = left;
        //只要左指针和右指针没有相遇进行循环
        while(left < right){
            //从右向左找第一个小于基准值的位置(这里也必须保证left < right),
            // 注意这里必须先从右边找第一个小于基准值的数，如果先从左边找的话会产生错误
            while(left < right && arr[right] >= value){
                right--;
            }
            //从左到右找第一个大于基准值的数位置
            while(left < right && arr[left] <= value){
                left++;
            }
            //找到之后，交换两个数
            swap(arr, left, right);
        }
        //遍历完整个数组后，交换基准值和两个指针相遇位置的值
        swap(arr, start, left);
        return left;
    }
    //快速排序
    public static void quickSort(int[] arr, int left, int right){
        if(left < right){
            //取出排序相遇位置的坐标
            int mid = quick(arr, left, right);
            //从上次相遇位置进行分组，对左右组分别进行快速排序
            quickSort(arr, left, mid - 1);
            quickSort(arr, mid + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] a = {24, 63, 15, 33, 51, 35, 76, 33};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
