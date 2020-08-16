/**
 * 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class MaxSubSequence {
    /**
     * f(i):以i为结尾的最大子数组和
     * 如果f(i-1)>0说明f(i-1)对我的f(i)增大有帮助 f(i)=f(i-1)+nums[i]
     * 如果f(i-1)<0说明f(i-1)对我的f(i)增大没有有帮助 f(i)=nums[i]
     */
    public int maxSubArray(int[] nums) {
        //f(i):以i为结尾的最大子数组和
        //如果f(i-1)>0说明f(i-1)对我的f(i)增大有帮助 f(i)=f(i-1)+nums[i]
        //如果f(i-1)<0说明f(i-1)对我的f(i)增大没有有帮助 f(i)=nums[i]
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i = 1; i < nums.length; i++){
            if(dp[i - 1] > 0){
                dp[i] = dp[i - 1] + nums[i];
            }else{
                dp[i] = nums[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
