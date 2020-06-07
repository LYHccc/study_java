/*三角矩阵
题目描述
给出一个三角形，计算从三角形顶部到底部的最小路径和，每一步都可以移动到下面一行相邻的数字，
例如，给出的三角形如下：
[↵     [2],↵    [3,4],↵   [6,5,7],↵  [4,1,8,3]↵]
最小的从顶部到底部的路径和是2 + 3 + 5 + 1 = 11。
注意：
如果你能只用O（N）的额外的空间来完成这项工作的话，就可以得到附加分，其中N是三角形中的行总数。
 */
import java.util.ArrayList;

public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int len = triangle.size();
        int[][] dp = new int[len][triangle.get(len - 1).size()];
        for(int i = len - 1; i >= 0; i--){
            for(int j = 0; j < triangle.get(i).size(); j++){
                if(i == len - 1){
                    dp[i][j] = triangle.get(i).get(j);
                }else{
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
                }
            }
        }

        return dp[0][0];
    }
}
