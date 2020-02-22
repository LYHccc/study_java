//冒泡排序
import java.util.Arrays;

public class BubbleSort {
    public static int[] bubbleSort(int[] a){
        for(int i = 0; i < a.length - 1; i++){//外层循环控制需要比较多少轮
            for(int j = 0; j < a.length - 1 - i; j++){//内层循环控制每一轮比较具体的比较过程
                if(a[j] > a[j + 1]){//如果前边的数大于后边的交换两数位置
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {24, 63, 15, 33, 51, 35, 76};
        System.out.println(Arrays.toString(bubbleSort(a)));
    }
}
