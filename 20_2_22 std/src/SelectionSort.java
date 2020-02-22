//选择排序
import java.util.Arrays;

public class SelectionSort {
    public static int[] selectSort(int[] a){
        for(int i = 0; i < a.length; i++){//外层循环代表找到的未排序范围中最小元素存的位置
            int min = i;//初始假定当前位置的值就是最小的，保存当前索引
            for(int j = i + 1; j < a.length; j++){//内循环代表在未排序范围中查找最小元素所在下标
                if(a[min] > a[j]){//更新下标
                    min = j;
                }
            }
            if(min != i){//如果最小值下标不是当前位置，更新此位置的值
                int temp = a[min];
                a[min] = a[i];
                a[i] = temp;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {24, 63, 15, 33, 51, 35, 76};
        System.out.println(Arrays.toString(selectSort(a)));
    }
}
