/*最小路径和
给定一个由非负整数填充的m x n的二维数组，现在要从二维数组的左上角走到右下角，
请找出路径上的所有数字之和最小的路径。
注意：你每次只能向下或向右移动。
 */
public class MinimumPathSum {
    public int minPathSum (int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < row; i++){
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for(int i = 1; i < col; i++){
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[row - 1][col - 1];
    }
}
