//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
public class Rotate {
    /*
    //方法一：双重循环依次挪动每一个位置的元素
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        for(int i = 0; i < k; i++){
            int temp = nums[len -1];
            for(int j = len - 1; j > 0; j--){
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }
    */

    //方法二：翻转
    //数组[1,2,3,4,5,6,7]向右移动k = 2个位置
    //1.先将整个数组[0, length -1]翻转:[7,6,5,4,3,2,1]
    //2.将[0, k - 1]从开始位置翻转要移动距离的元素个数:[6,7,5,4,3,2,1]
    //3.将剩余的[k, length -1]翻转:[6,7,1,2,3,4,5]
    public void reversal(int[] nums, int start, int end){//翻转数组
        //将从[start, end]的所有元素进行前后位置的交换即翻转
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public void rotate(int[] nums, int k) {//三次翻转移动数组
        int len = nums.length;
        //处理k超过数组长度而越界的情况
        k %= len;
        reversal(nums, 0, len -1);
        reversal(nums, 0, k -1);
        reversal(nums, k, len -1);
    }
}
