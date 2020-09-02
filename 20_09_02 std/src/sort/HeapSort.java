package sort; /**
 * 堆排序
 */
import java.util.Arrays;

public class HeapSort {
    private static void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    private static void shiftDownBig(int[] arr, int parent, int len){
        int child = parent * 2 + 1;
        while(child < len){
            if(child + 1 < len && arr[child + 1] > arr[child]){
                child++;
            }
            if(arr[child] > arr[parent]) {
                swap(arr, parent, child);
                parent = child;
                child = parent * 2 + 1;
            }else{
                break;
            }
        }
    }

    public static int[] heapSort(int[] arr){
        int len = arr.length;
        for(int i = (len - 2) / 2; i >= 0; i--){
            shiftDownBig(arr, i, len);
        }
        int end = len - 1;
        while (end > 0){
            swap(arr, 0, end);
            shiftDownBig(arr, 0, end);
            end--;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] a = {24, 63, 15, 33, 51, 35, 76, 33};
        System.out.println(Arrays.toString(heapSort(a)));
    }
}
