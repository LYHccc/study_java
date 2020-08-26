/**
 * 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回-1。
 */
import java.util.Arrays;

public class CoinChange {
    /*
    //方法一：回溯，超时
    private static int min;
    private void dfs(int[] coins, int amount, int count){
        if(amount == 0)
            min = Math.min(min, count);
        for(int i = 0; i < coins.length; i++){
            if(amount < coins[i])
                break;
            dfs(coins, amount - coins[i], count + 1);
        }
    }

    public int coinChange(int[] coins, int amount) {
        min = Integer.MAX_VALUE;
        Arrays.sort(coins);
        dfs(coins, amount, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    */

    /**
     * 动态规划
     * f(i)：目标值为i的组合的最小个数
     * 对于每个i可以由给定数组中的任意一个数coin加上某一个数temp得到
     * 因此上i的组合数的个数其中的一种情况就是组成temp的最小个数f(temp) + 1
     * 因为给定数组中没有负数，所以coin一定小于等于i，等于i时temp=0，也就是只需要一个面值为coin的硬币，因此上f(0) = 0
     * 如果不存在可以组合成temp的组合，即f(temp) = -1，continue
     * 状态方程：dp[i] = Math.min(dp[i], dp[i - coin] + 1);
     * 初始状态：f(0) = 0
     * @param coins 给定不同面额的硬币
     * @param amount 目标值
     * @return 组合的最小硬币数
     */
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0) return -1;
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            dp[i] = -1;
            for(int coin : coins){
                if(coin <= i){
                    if(dp[i - coin] == -1){
                        continue;
                    }else{
                        if(dp[i] == -1){
                            dp[i] = dp[i - coin] + 1;
                        }else{
                            dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                        }
                    }
                }
            }
        }

        return dp[amount];
    }
}
