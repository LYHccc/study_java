//快速排序(非递归实现)
import java.util.Arrays;
import java.util.Stack;

public class QuickSort {
    public static void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
    //双指针进行一次排序过程
    public static int quick(int[] arr, int left, int right){
        int value = arr[left];
        int prev = left;//慢指针
        int cur = left + 1;//快指针
        while(cur <= right){
            if(arr[cur] < value && prev++ != cur){//找到小于基准值的位置，如果prev走向下一个位置不是cur的位置，说明此时prev指向的值大于基准值
                swap(arr, prev, cur);
            }
            cur++;
        }
        swap(arr, left, prev);
        return prev;
    }
    //非递归快速排序
    public static int[] quickSort(int[] arr, int left, int right){
        Stack<Integer> stack = new Stack<>();
        if(left < right){//先将数组左右下标压入栈中(注意这里你的压栈顺序，等会取出时要先取后压入的)
            stack.push(left);//先压左
            stack.push(right);//右
        }
        while(!stack.isEmpty()){
            //每次取出两个元素，作为要排序区间的左右范围
            int right1 = stack.pop();//先取右
            int left1 = stack.pop();//左
            int mid = quick(arr, left1, right1);//对当前区间进行排序，并记录中间位置的下标
            if(mid - 1 > left1){//如果中间位置向左的区间元素数量大于1，将左区间的左右下标压入栈
                stack.push(left1);//先压左
                stack.push(mid - 1);//右
            }
            if(mid + 1 < right1){//同理
                stack.push(mid + 1);
                stack.push(right1);
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] a = {24, 63, 15, 33, 51, 35, 76, 33};
        System.out.println(Arrays.toString(quickSort(a, 0, a.length - 1)));
    }
}
