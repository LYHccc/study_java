/*不同子序列
给定一个字符串S和一个字符串T，计算S中的T的不同子序列的个数。
字符串的子序列是由原来的字符串删除一些字符（也可以不删除）在不改变相对位置的情况下的剩余字符
（例如，"ACE"is a subsequence of"ABCDE"但是"AEC"不是）
例如：
S ="rabbbit", T ="rabbit"
返回3
 */
public class DistinctSubsequences {
    /**
     * 问题解释：S可以分割成多少种不同的子串与T相同，示例：S ="rabbbit", T ="rabbit"
     * 分割S="ra" "bbit" , "rab" "bit" , "rabb" "it" 删除一个b可以分割出三种
     * 状态方程F(i, j):字符串S[1,i]的子串与字符串T[1,j]子串相同的个数
     * if(S[i] == T[i]) F(i, j) = F(i - 1, j - 1) + F(i - 1, j)
     * 第一种情况是S[i - 1]和T[i - 1]加上S[i]和T[j]，F(i - 1, j - 1)的子串分割情况依然有效
     * 第二种情况是加上T[i]之后，T[i]变长了，S[i - 1]可能产生新的子串满足情况F(i - 1, j)
     * else F(i, j) = F(i - 1, j)
     * 不相等的话上述的第一种情况就不满足了
     * @param S
     * @param T
     * @return
     */
    public int numDistinct (String S, String T) {
        int len1 = S.length();
        int len2 = T.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for(int i = 0; i <= len1; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                if(S.charAt(i - 1) == T.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[len1][len2];
    }
}
