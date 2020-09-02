package sort; /**
 * 快速排序
 */
import java.util.Arrays;

public class QuickSort {
    private static void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    private static int quick(int[] arr, int left, int right){
        int start = left;
        int value = arr[start];
        while(left < right){
            while (left < right && arr[right] >= value){
                right--;
            }
            while(left < right && arr[left] <= value){
                left++;
            }
            swap(arr, left, right);
        }
        swap(arr, start, left);
        return left;
    }

    private static void sort(int[] arr, int left, int right){
        if(left < right){
            int mid = quick(arr, left, right);
            sort(arr, left, mid);
            sort(arr, mid + 1, right);
        }
    }

    public static int[] quickSort(int[] arr){
        sort(arr, 0, arr.length - 1);
        return arr;
    }

    public static void main(String[] args) {
        int[] a = {24, 63, 15, 33, 51, 35, 76, 33};
        System.out.println(Arrays.toString(quickSort(a)));
    }
}
