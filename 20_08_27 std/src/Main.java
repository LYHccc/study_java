/**
 * 最大自增子串
 * 给定一个数组，输出最大自增子串的元素和
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        StringBuilder str = new StringBuilder(string);
        str.deleteCharAt(0);
        str.deleteCharAt(str.length() - 1);
        String[] sArr = str.toString().split(",");
        int len = sArr.length;
        int[] arr = new int[len];
        for(int i = 0; i < len; i++){
            arr[i] = Integer.valueOf(sArr[i]);
        }
        int[] dp = new int[len];
        dp[0] = arr[0];
        int res = dp[0];
        for(int i = 1; i < len; i++){
            if(dp[i - 1] > 0){
                dp[i] = dp[i - 1] + arr[i];
            }else{
                dp[i] = arr[i];
            }
            res = Math.max(res, dp[i]);
        }

        System.out.println(res);
    }
}
