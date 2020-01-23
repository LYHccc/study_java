//给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。

public class ThirdMax {
    public static int thirdMax(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int count = 0;
        boolean first = true;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == Integer.MIN_VALUE && first){
                count++;
                first = false;
            }
            if(nums[i] > max1){
                count++;
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            }else if(nums[i] > max2 && nums[i] < max1){
                count++;
                max3 = max2;
                max2 = nums[i];
            }else if(nums[i] > max3 && nums[i] < max2){
                count++;
                max3 = nums[i];
            }
        }
        if(count < 3){
            return max1;
        }
        return max3;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1};
        System.out.println(thirdMax(nums));
    }
}
