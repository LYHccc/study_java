/*岛屿的最大面积
给定一个包含了一些 0 和 1 的非空二维数组 grid 。
一个岛屿是由一些相邻的1(代表土地)构成的组合，这里的[相邻]要求两个 1 必须在水平或者竖直方向上相邻。
你可以假设 grid 的四个边缘都被 0（代表水）包围着。
找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 */
public class MaxAreaOfIsland {
    private static final int[][] position = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static boolean[][] flag;
    private static int count;

    private void dfs(int[][] grid, int row, int col, int x, int y){
        count++;
        flag[x][y] = true;
        for(int i = 0; i < 4; i++){
            int newX = x + position[i][0];
            int newY = y + position[i][1];
            if(newX < 0 || newX >= row || newY < 0 || newY >= col){
                continue;
            }
            if(grid[newX][newY] == 1 && !flag[newX][newY]){
                dfs(grid, row, col, newX, newY);
            }
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        flag = new boolean[row][col];
        int max = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1 && !flag[i][j]){
                    count = 0;
                    dfs(grid, row, col, i, j);
                    max = Math.max(max, count);
                }
            }
        }

        return max;
    }
}
