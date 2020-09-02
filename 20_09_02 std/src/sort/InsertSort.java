package sort; /**
 * 直接插入排序
 */
import java.util.Arrays;

public class InsertSort {
    public static int[] insertSort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            int index = i;
            int value = arr[index + 1];
            while(index >= 0 && arr[index] > value){
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = value;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] a = {24, 63, 15, 33, 51, 35, 76, 33};
        System.out.println(Arrays.toString(insertSort(a)));
    }
}
