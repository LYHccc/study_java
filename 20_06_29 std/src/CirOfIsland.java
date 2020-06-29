/*岛屿的周长
给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
网格中的格子水平和垂直方向相连（对角线方向不相连）。
整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 */
public class CirOfIsland {
    private static final int[][] position = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int islandPerimeter(int[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    count += 4;
                    for(int k = 0; k < 4; k++){
                        int newX = i + position[k][0];
                        int newY = j + position[k][1];
                        if(newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length){
                            continue;
                        }
                        if(grid[newX][newY] == 1)
                            count--;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 1}, {1, 1}};
        System.out.println(islandPerimeter(arr));
    }
}
