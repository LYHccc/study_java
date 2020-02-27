//向下调整大根堆和小根堆
import java.util.Arrays;

public class ShiftDown {
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void shiftDownBig(int[] arr, int length, int parent){//向下调整大根堆
        int child = parent * 2 + 1;//左孩子下标
        while(child < length){
            if(child + 1< length && arr[child + 1] > arr[child]){//如果右孩子存在并且值大于左孩子，要比教的就是右孩子，更新child
                child++;
            }
            if(arr[child] > arr[parent]){//如果child位置的值大于parent位置的值
                swap(arr, child, parent);//交换两个值
                parent = child;//继续向下调整，更新parent和child的值
                child = parent * 2 + 1;
            }else{
                break;
            }
        }
    }

    public static void shiftDownSmall(int[] arr, int length, int parent){//向下调整小根堆
        int child = parent * 2 + 1;//左孩子下标
        while(child < length){
            if(child + 1 < length && arr[child + 1] < arr[child]){
                child++;
            }
            if(arr[child] < arr[parent]){
                swap(arr, child, parent);
                parent = child;
                child = parent * 2 + 1;
            }else{
                break;
            }
        }
    }

    public static void creatBigHeap(int[] arr){//建立大根堆
        for(int i = (arr.length - 2); i >= 0; i--){
            shiftDownBig(arr, arr.length, i);
        }
    }

    public static void creatSmallHeap(int[] arr){//建立小根堆
        for(int i = (arr.length - 2); i >= 0; i--){
            shiftDownSmall(arr, arr.length, i);
        }
    }


    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 3, 19, 22, 2};
        int[] arr1 = arr.clone();
        creatBigHeap(arr);
        System.out.println(Arrays.toString(arr));
        creatSmallHeap(arr1);
        System.out.println(Arrays.toString(arr1));
    }
}
