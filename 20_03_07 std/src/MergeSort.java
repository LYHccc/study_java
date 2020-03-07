//归并排序实现
import java.util.Arrays;

public class MergeSort {
    //合并一次数组
    public static void merge(int[] arr, int left, int mid, int right, int[] temp){
        int start1 = left, end1 = mid;//合并的一个数组的左右区间
        int start2 = mid + 1, end2 = right;//合并的另一个数组的左右区间
        int index = left;//记录合并数组最开始的下标
        while(start1 <= mid && start2 <= end2){//合并
            if(arr[start1] <= arr[start2]){//先存小的
                temp[index++] = arr[start1++];
            }else{
                temp[index++] = arr[start2++];
            }
        }
        //判断是否还有剩余元素，如果有将剩余元素添加
        while(start1 <= end1){
            temp[index++] = arr[start1++];
        }
        while(start2 <= end2){
            temp[index++] = arr[start2++];
        }
        for(int i = left; i <= right; i++){//拷贝
            arr[i] = temp[i];
        }
    }

    //进行递归归并排序
    public static void mSort(int[] arr, int left, int right, int[] temp){
        if(left >= right){
            return;
        }
        int mid = (left + right) / 2;//中间坐标
        mSort(arr, left, mid, temp);//左边数组进行排序
        mSort(arr, mid + 1, right, temp);//右边数组进行排序
        merge(arr, left, mid, right, temp);//进行合并
    }
    //归并排序
    public static int[] mergeSort(int[] arr){
        int[] temp = new int[arr.length];
        mSort(arr, 0, arr.length - 1, temp);
        return arr;
    }

    /*
    非递归
   public static int[] mergeSort(int[] arr){
       int[] temp = new int[arr.length];
       for(int i = 1; i < arr.length; i *= 2){//外层循环i是每次归并的元素个数
           for(int j = 0; j < arr.length; j += i * 2){//内层循环j是下次归并的起始位置下标
               int left = j;
               int mid = left + i - 1;
               if(mid >= arr.length - 1){//如果右半部分没有数据，不用进行归并
                   continue;
               }
               int right = left + 2 * i - 1;
               if(right > arr.length - 1){//如果右区间下标越界
                   right = arr.length - 1;
               }
               merge(arr, left, mid, right, temp);
           }
       }
       return arr;
   }
   */

    public static void main(String[] args) {
        int[] a = {24, 63, 15, 33, 51, 35, 76, 33};
        System.out.println(Arrays.toString(mergeSort(a)));
    }
}
