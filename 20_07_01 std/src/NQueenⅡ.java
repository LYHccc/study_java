/*n皇后Ⅱ
n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 */
import java.util.ArrayList;
import java.util.List;

public class NQueenⅡ {
    /*
    //方法一：用数组存放皇后的信息，有皇后置1，没皇后置0
    private static int count;
    private boolean isConflict(int[][] arr, int row, int col, int n){
        for(int i = 0; i < n; i++){
            if(i == row) continue;
            if(arr[i][col] == 1)return false;
            if(row + col - i >= 0 && row + col - i < n && arr[i][row + col - i] == 1) return false;
            if(col - row + i >= 0 && col - row + i < n && arr[i][col - row + i] == 1) return false;             }
        return true;
    }

    private void dfs(int[][] arr, int curRow, int n){
        if(curRow == n){
            count++;
            return;
        }
        for(int i = 0; i < n; i++){
            if(isConflict(arr, curRow, i, n)){
                arr[curRow][i] = 1;
                dfs(arr, curRow + 1, n);
                arr[curRow][i] = 0;
            }
        }
    }

    public int totalNQueens(int n) {
        int[][] arr = new int[n][n];
        count = 0;
        dfs(arr, 0, n);
        return count;
    }
    */


    //方法二：用list存放有皇后的位置坐标信息
    private static int count;
    //当前位置放置皇后是否会有冲突,false有冲突，true没冲突
    private boolean isConflict(List<int[]> list, int row, int col){
        for(int[] arr : list){
            if(arr[1] == col || arr[0] - arr[1] == row - col || arr[0] + arr[1] == row + col){
                return false;
            }
        }
        return true;
    }

    private void dfs(List<int[]> list, int curRow, int n){
        if(curRow == n){
            count++;
            return;
        }
        for(int i = 0; i < n; i++){
            if(isConflict(list, curRow, i)){
                list.add(new int[]{curRow, i});
                dfs(list, curRow + 1, n);
                list.remove(list.size() - 1);
            }
        }
    }

    public int totalNQueens(int n) {
        List<int[]> list = new ArrayList<>();
        count = 0;
        dfs(list, 0, n);
        return count;
    }
}
