package sort;

import java.util.Arrays;

public class ShellSort {
    public static int[] shellSort(int[] arr){
        int len = arr.length;
        int gap = len / 2;
        while(gap > 0){
            for(int i = 0; i < len - gap; i++){
                int index = i;
                int value = arr[index + gap];
                while(index >= 0 && arr[index] > value){
                    arr[index + gap] = arr[index];
                    index -= gap;
                }
                arr[index + gap] = value;
            }
            gap /= 2;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] a = {24, 63, 15, 33, 51, 35, 76, 33};
        System.out.println(Arrays.toString(shellSort(a)));
    }
}
