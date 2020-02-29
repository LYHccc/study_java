//希尔排序
import java.util.Arrays;

public class ShellSort {
    public static int[] shellSort(int[] arr){
        int len = arr.length;
        int gap = len / 2;
        while(gap > 0){
            for(int i = 0; i < len - gap; i++){
                int index = i;//组内要与插入元素比较的范围内的最后一个元素
                int value = arr[index + gap];//要插入的元素
                while(index >= 0 && arr[index] > value){//如果组内上一个元素大于要插入的，将上边的元素往后移
                    arr[index + gap] = arr[index];//往后移
                    index -= gap;//向前走
                }
                arr[index + gap] = value;//插入元素
            }
            gap /= 2;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] a = {24, 63, 15, 33, 51, 35, 76};
        System.out.println(Arrays.toString(shellSort(a)));
    }
}
