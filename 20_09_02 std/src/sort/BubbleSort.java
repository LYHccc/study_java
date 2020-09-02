package sort; /**
 * 冒泡排序
 */
import java.util.Arrays;

public class BubbleSort {
    private static void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    private static int[] bubbleSort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            boolean flag = false;
            for(int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j] > arr[j + 1]){
                    flag = true;
                    swap(arr, j, j + 1);
                }
            }
            if(!flag){
                break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] a = {24, 63, 15, 33, 51, 35, 76, 33};
        System.out.println(Arrays.toString(bubbleSort(a)));
    }
}
