/*调整数组的顺序使奇数位于偶数之前
题目描述
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class AdjustArrayOrder {
    /*
    //方法一：找到第一个偶数，将后边的奇数全部搬移到这个偶数前边来
    //将奇数搬移到第一个偶数之前
    private static void move(int[] arr, int oddIndex, int evenIndex){
        int odd = arr[oddIndex];
        for(int i = oddIndex - 1; i >= evenIndex; i--){
            arr[i + 1] = arr[i];
        }
        arr[evenIndex] = odd;
    }

    public void reOrderArray(int [] array) {
        int even = 0;
        int len = array.length;
        //找到第一个偶数
        while(even < len && array[even] % 2 != 0){
            even++;
        }
        if(even == len) return;
        int odd = even;
        for(int i = odd + 1; i < len; i++){
            //找到奇数
            if(array[i] % 2 != 0){
                move(array, i, even);
                even++;
            }
        }
    }
    */

    //方法二：开辟一个额外的数组，初始化为原数组的拷贝，
    //然后遍历拷贝数组，将奇数放在原数组的前边，偶数放在后边
    public void reOrderArray(int [] array) {
        int len = array.length;
        int[] temp = new int[len];
        int index = 0;
        for(int i = 0; i < len; i++){
            temp[i] = array[i];
            if(temp[i] % 2 != 0){
                array[index++] = temp[i];
            }
        }
        for(int i = 0; i < len; i++){
            if(temp[i] % 2 == 0){
                array[index++] = temp[i];
            }
        }
    }
}
