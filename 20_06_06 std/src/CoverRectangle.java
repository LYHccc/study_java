/*矩形覆盖
我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class CoverRectangle {
    public int RectCover(int target) {
        /*
        int[] dp = new int[target + 1];
        if(target == 0) return 0;
        if(target == 1) return 1;
        if(target == 2) return 2;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= target; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
        */


        if(target == 0) return 0;
        if(target == 1) return 1;
        if(target == 2) return 2;
        int dp1 = 1;
        int dp2 = 2;
        int dp = 0;
        for(int i = 3; i <= target; i++){
            dp = dp1 + dp2;
            dp1 = dp2;
            dp2 = dp;
        }
        return dp;
    }
}
