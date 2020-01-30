//给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
//你找到的子数组应是最短的，请输出它的长度。

import java.util.Arrays;

public class FindUnsortedSubarray {
    public static int findUnsortedSubarray(int[] nums) {
        int[] temp = new int[nums.length];
        for(int i = 0; i < nums.length; i++)
            temp[i] = nums[i];
        Arrays.sort(temp);
        int left = temp.length - 1;
        int right = 0;
        for(int i = 0; i < temp.length; i++){
            if(nums[i] != temp[i]){
                left = Math.min(left, i);
                right = Math.max(right, i);
            }
        }
        return right > left ? right - left + 1 : 0;
    }

    public static void main(String[] args) {
        int[] nums = {2,6,4,8,10,9,15};
        System.out.println(findUnsortedSubarray(nums));
    }
}
