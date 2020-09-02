package sort; /**
 * 归并排序
 */
import java.util.Arrays;

public class MergeSort {
    private static void merge(int[] arr, int left, int mid, int right, int[] temp){
        int start1 = left, end1 = mid;
        int start2 = mid + 1, end2 = right;
        int start = left;
        while(start1 <= end1 && start2 <= end2){
            if(arr[start1] <= arr[start2]){
                temp[start++] = arr[start1++];
            }else{
                temp[start++] = arr[start2++];
            }
        }
        while(start1 <= end1){
            temp[start++] = arr[start1++];
        }
        while(start2 <= end2){
            temp[start++] = arr[start2++];
        }
        for(int i = left; i <= right; i++){
            arr[i] = temp[i];
        }
    }

    private static void sort(int[] arr, int left, int right, int[] temp){
        if(left < right){
            int mid = (left + right) / 2;
            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    public static int[] mergeSort(int[] arr){
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
        return  arr;
    }

    public static void main(String[] args) {
        int[] a = {24, 63, 15, 33, 51, 35, 76, 33};
        System.out.println(Arrays.toString(mergeSort(a)));
    }
}
