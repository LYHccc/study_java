/*字符串分割
题目描述
给出一个字符串s，分割s使得分割出的每一个子串都是回文串
计算将字符串s分割成回文分割结果的最小切割数
例如:给定字符串s="aab",
返回1，因为回文分割结果["aa","b"]是切割一次生成的。
 */
public class PalindromePartitioningⅡ {
    private static boolean isPalin(String s){
        int left = 0, right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public int minCut (String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        for(int i = 1; i <= len; i++){
            if(isPalin(s.substring(0, i))){
                dp[i] = 0;
            }else{
                dp[i] = i - 1;
                for(int j = 1; j < i; j++){
                    if(isPalin(s.substring(j, i))){
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }

        return dp[len];
    }
}
