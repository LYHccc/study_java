/*编辑距离
给定两个单词word1和word2，请计算将word1转换为word2至少需要多少步操作。
你可以对一个单词执行以下3种操作：
a）在单词中插入一个字符
b）删除单词中的一个字符
c）替换单词中的一个字符
 */
import java.util.Scanner;

public class EditDistance {
    /**
     * @param word1
     * @param word2
     * @return
     * 状态方程F(i,j)：word1的前i个字符转换为word2的前j个字符的编辑距离
     * F(i,j) = Math.min(F(i - 1, j) + 1, F(i, j - 1) + 1, F(i - 1, j - 1) + (word1[i] == word2[j] ? 0 : 1))
     * F(i - 1, j) + 1 word1前i - 1个字符转换为word2的前j个字符，需要删除第word1[i]字符
     * F(i, j - 1) + 1 word1前i个字符转换为word2的前j - 1个字符，需要在word1[i]位置添加字符
     *
     * F(i - 1, j - 1) + (word1[i] == word2[j] ? 0 : 1)word1前i个字符转换为word2的前j个字符，
     * 如果word1[i] != word2[j]，则要替换word1[i]位置的字符，如果相等则不用
     */
    public static int minDistance (String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if(len1 == 0) return len2;
        if(len2 == 0) return len1;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for(int i = 0; i <= len1; i++){
            dp[i][0] = i;
        }
        for(int i = 0; i <= len2; i++){
            dp[0][i] = i;
        }

        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
            }
        }

        return dp[len1][len2];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        System.out.println(minDistance(s1, s2));
    }
}
