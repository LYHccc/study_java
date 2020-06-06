/*
给定一个字符串s和一组单词dict，判断s是否可以用空格分割成一个单词序列，
使得单词序列中所有的单词都是dict中的单词（序列可以包含一个或多个单词）。
例如:
给定s=“leetcode”；
dict=["leet", "code"].
返回true，因为"leetcode"可以被分割成"leet code".
 */
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        /*
        int len = s.length();
        boolean[] dp = new boolean[len];
        for(int i = 0; i < len; i++){
            if(dict.contains(s.substring(0, i + 1))){
                dp[i] = true;
                continue;
            }

            for(int j = 0; j < i; j++){
                if(dp[j] && dict.contains(s.substring(j + 1, i + 1))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[len - 1];
        */

        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for(int i = 1; i <= len; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && dict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
