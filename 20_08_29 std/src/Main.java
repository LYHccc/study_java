/**
 * 礼物的最大值
 * 给定一个二维数组，数组中存放每个位置的礼物价值
 * 从[0,0]出发，可以向下和向右移动，找出移动到数组右下角可获得的最大礼物价值
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] aid = s.split(",");
        int row = Integer.valueOf(aid[0]);
        int col = Integer.valueOf(aid[1]);
        int[][] arr = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                arr[i][j] = scanner.nextInt();
            }
        }
        int[][] dp = new int[row][col];
        dp[0][0] = arr[0][0];
        for(int i = 1; i < row; i++){
            dp[i][0] = dp[i - 1][0] + arr[i][0];
        }
        for(int i = 1; i < col; i++){
            dp[0][i] = dp[0][i - 1] + arr[0][i];
        }
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + arr[i][j];
            }
        }
        System.out.println(dp[row - 1][col - 1]);
    }
}
