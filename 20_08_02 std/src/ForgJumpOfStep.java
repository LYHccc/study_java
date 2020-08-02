/*青蛙跳台阶
题目描述
一只青蛙一次可以跳上1级台阶，也可以跳上2级。
求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class ForgJumpOfStep {
    public int JumpFloor(int target) {
        if(target == 1) return 1;
        int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= target; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }
}
