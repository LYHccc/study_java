//插入排序
import java.util.Arrays;

public class InsertionSort {
    public static int[] insertionSort(int[] a){
        for(int i = 1; i < a.length; i++){//外层循环表示要移动的元素位置
            int index = i;//记录要移动的下标
            int value = a[i];//记录要移动的值
            while(index > 0 && a[index - 1] > value){//在index > 0的条件下只要index前一个位置的值大于value，就将上一个位置的值向后挪
                a[index] = a[index - 1];
                index--;
            }
            a[index] = value;//找到上一个值小于value的位置或者到了0位置，那么value就应该排在这个位置
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {24, 63, 15, 33, 51, 35, 76};
        System.out.println(Arrays.toString(insertionSort(a)));
    }
}
