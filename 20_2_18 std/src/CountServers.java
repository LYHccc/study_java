//这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。
//如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。
//请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。

public class CountServers {
    public int countServers(int[][] grid) {
        int[] row = new int[grid.length];
        int[] line = new int[grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    row[i]++;
                    line[j]++;
                }
            }
        }
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1 && (row[i] > 1 || line[j] > 1)){
                    count++;
                }
            }
        }
        return count;
    }
}
