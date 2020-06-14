/*岛屿数量
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
此外，你可以假设该网格的四条边均被水包围。
 */
public class IslandNumber {
    private static final int[][] position = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static boolean[][] flag;

    private void dfs(char[][] grid, int row, int col, int x, int y){
        flag[x][y] = true;
        for(int i = 0; i < 4; i++){
            int newX = x + position[i][0];
            int newY = y + position[i][1];
            if(newX < 0 || newX >= row || newY < 0 || newY >= col){
                continue;
            }
            if(grid[newX][newY] == '1' && flag[newX][newY] == false){
                dfs(grid, row, col, newX, newY);
            }
        }
    }

    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        flag = new boolean[row][col];
        int count = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1' && flag[i][j] == false){
                    count++;
                    dfs(grid, row, col, i, j);
                }
            }
        }
        return count;
    }
}
