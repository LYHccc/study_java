/*路径总数Ⅱ
继续思考题目"Unique Paths":
如果在图中加入了一些障碍，有多少不同的路径？
分别用0和1代表空区域和障碍
例如：
下图表示有一个障碍在3*3的图中央。
[↵  [0,0,0],↵  [0,1,0],↵  [0,0,0]↵]有2条不同的路径
备注：m和n不超过100.
 */
public class UniquePathsⅡ {
    public int uniquePathsWithObstacles (int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        for(int i = 0; i < row; i++){
            if(obstacleGrid[i][0] == 0){
                dp[i][0] = 1;
            }else{
                break;
            }
        }
        for(int i = 0; i < col; i++){
            if(obstacleGrid[0][i] == 0){
                dp[0][i] = 1;
            }else{
                break;
            }
        }

        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[row - 1][col - 1];
    }
}
