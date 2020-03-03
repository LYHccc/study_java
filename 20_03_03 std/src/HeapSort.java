//堆排序实现
import java.util.Arrays;

public class HeapSort {
    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void shiftDownBig(int[] arr, int length, int parent){// 向下调整
        int child = parent * 2 + 1;
        while(child < length ){
            if(child + 1 < length && arr[child + 1] > arr[child]){
                child++;
            }
            if(arr[child] > arr[parent]){
                swap(arr, child, parent);
                parent = child;
                child = parent * 2 + 1;
            }else{
                break;
            }
        }
    }

    public static void heapSort(int[] arr){
        int length = arr.length;
        for(int i = (length - 2) / 2; i >= 0; i--){//建堆
            shiftDownBig(arr, length, i);
        }
        int end = length - 1;//最后一个下标
        while(end > 0){//一直调整到数组第一个
            swap(arr, 0, end);//交换堆顶和未排序范围最后一个(堆顶是最大的，这样就放在了未排序的最后一个，完成这个元素的排序)
            shiftDownBig(arr, end, 0);//将堆顶换上去的元素在未排序范围内向下调整
            end--;
        }
    }

    public static void main(String[] args) {
        int[] a = {24, 63, 15, 33, 51, 35, 76, 33};
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }
}
