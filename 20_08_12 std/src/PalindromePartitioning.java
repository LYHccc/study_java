/**
 * 题目描述：回文串分割
 * 给出一个字符串s，分割s使得分割出的每一个子串都是回文串
 * 计算将字符串s分割成回文分割结果的最小切割数
 * 例如:给定字符串s="aab",
 * 返回1，因为回文分割结果["aa","b"]是切割一次生成的。
 */
public class PalindromePartitioning {
    //方法一：每次都判断回文
    private static boolean isPalindromic(String s){
        int left = 0, right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    //方法二：用数组记录[i,j]区间的字符是否是回文
    private static boolean[][] isPali(String s){
        //f(i, j):区间[i, j]是否是回文串
        //f(i ,j) = (s(i)==s(j) && f(i + 1, j - 1)))
        //初始状态：f(i,j)=false;
        int len = s.length();
        boolean[][] flag = new boolean[len][len];
        for(int i = len - 1; i >= 0; i--){
            for(int j = i; j < len; j++){
                if(i == j){//[i,j]只有一个元素
                    flag[i][j] = true;
                }else if(i + 1 == j){//[i,j]有两个元素
                    if(s.charAt(i) == s.charAt(j)){
                        flag[i][j] = true;
                    }else{
                        flag[i][j] = false;
                    }
                }else{//[i,j]之间元素个数 > 2
                    flag[i][j] = flag[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                }
            }
        }

        return flag;
    }

    public int minCut (String s) {
        //f(i):前i个字符的最小分割次数
        //f(i)=min(f(i), f(j) + 1)）其中 j < i && [j + 1, i]是回文串
        //初始状态：f(i) = i - 1 即每一个串的最大分割次数
        int len = s.length();
        int[] dp = new int[len + 1];
        boolean[][] pali = isPali(s);
        for(int i = 1; i <= len; i++){
            if(isPalindromic(s.substring(0, i))){
                dp[i] = 0;
            }else{
                dp[i] = i - 1;
                for(int j = 1; j < i; j++){
                    /*
                    if(isPalindromic(s.substring(j, i))){
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                    */
                    if(pali[j][i - 1]){
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }

        return dp[len];
    }
}
