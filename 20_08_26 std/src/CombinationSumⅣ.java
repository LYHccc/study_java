import java.util.Arrays;

/**
 * 组合总数Ⅳ
 * 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
 */
public class CombinationSumⅣ {
    /*
    //方法一：回溯，超时
    private static int count;
    private void dfs(int[] nums, int target){
        if(target == 0){
            count++;
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(target < nums[i])
                break;
            dfs(nums, target - nums[i]);
        }
    }

    public int combinationSum4(int[] nums, int target) {
        if(nums.length == 0 || target <= 0) return 0;
        Arrays.sort(nums);
        count = 0;
        dfs(nums, target);
        return count;
    }
    */

    /**
     * 方法二：动态规划
     * f(i)：目标值为i的组合总数
     * 对于每个i可以由给定数组中的任意一个数num加上某一个数temp得到
     * 因此上i的组合数其中的一种情况就是组成temp的组合总数f(temp)
     * 因为给定数组中没有负数，所以num一定小于等于i，等于i时temp=0，这算一种组合情况，因此上f(0)=1
     * 状态方程：for(num : nums) if(num <= i) f(i) += f(temp)
     * 初始状态：f(0) = 1
     * @param nums 给定数组
     * @param target 目标值
     * @return 组合总数
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 0; i <= target; i++){
            for(int num : nums){
                if(num <= i){
                    dp[i] += dp[i - num];
                }
            }
        }

        return dp[target];
    }
}
