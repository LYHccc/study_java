/*机器人的运动范围
题目描述：
地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class RangeOfSportOfTheRobot {
    private static int count;
    private static int[][] position = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static boolean[][] visited;

    private static int sumCoord(int num){
        int sum = 0;
        while(num != 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    private static void dfs(int threshold, int row, int col, int curRow, int curCol){
        count++;
        visited[curRow][curCol] = true;
        for(int i = 0; i < 4; i++){
            int x = curRow + position[i][0];
            int y = curCol+ position[i][1];
            if(x < 0 || x >= row || y < 0 || y >= col)
                continue;
            int sum = sumCoord(x) + sumCoord(y);
            if(sum <= threshold && !visited[x][y])
                dfs(threshold, row, col, x, y);
        }
    }

    public static int movingCount(int threshold, int rows, int cols){
        if(threshold < 0){
            return 0;
        }
        visited = new boolean[rows][cols];
        count = 0;
        dfs(threshold, rows, cols, 0, 0);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(5, 10, 10));
    }
}
