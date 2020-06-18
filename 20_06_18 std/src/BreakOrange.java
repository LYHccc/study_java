/*腐烂的橘子
在给定的网格中，每个单元格可以有以下三个值之一：
值 0 代表空单元格；
值 1 代表新鲜橘子；
值 2 代表腐烂的橘子。
每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 */
import java.util.LinkedList;
import java.util.Queue;

public class BreakOrange {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] next = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean flag = false;
            for(int i = 0; i < size; i++){
                int[] temp = queue.poll();
                for(int j = 0; j < 4; j++){
                    int newX = temp[0] + next[j][0];
                    int newY = temp[1] + next[j][1];
                    if(newX < 0 || newX >= row || newY < 0 || newY >= col || grid[newX][newY] != 1){
                        continue;
                    }
                    flag = true;
                    grid[newX][newY] = 2;
                    queue.offer(new int[]{newX, newY});
                }
            }
            if(flag){
                count++;
            }
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return count;
    }
}
