/*数字和为sum的方法数
题目描述：
给定一个有n个正整数的数组A和一个整数sum,求选择数组A中部分数字和为sum的方案数。
当两种选取方案有一个数字的下标不一样,我们就认为是不同的组成方案。

输入描述:
输入为两行:
 第一行为两个正整数n(1 ≤ n ≤ 1000)，sum(1 ≤ sum ≤ 1000)
 第二行为n个正整数A[i](32位整数)，以空格隔开。

输出描述:
输出所求的方案数
 */
import java.util.Scanner;

public class NumMethod {
    /*
    //方法一：递归，时间复杂度过大，过40%
    private static int n;
    private static int[] arr;
    private static int count(int k, int sum){
        if(sum == 0){
            return 1;
        }
        if(k <= 0){
            return 0;
        }
        return count(k - 1, sum) + count(k - 1, sum - arr[k]);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int sum = scanner.nextInt();
        arr = new int[n + 1];
        for(int i = 1; i <= n; i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println(count(n, sum));
    }
    */

    //方法二：dp
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }

        long[] dp = new long[sum + 1];
        dp[0] = 1;
        for(int i = 0; i < n; i++){
            for(int j = sum; j >= arr[i]; j--){
                dp[j] += dp[j - arr[i]];
            }
        }
        System.out.println(dp[sum]);
    }
}
