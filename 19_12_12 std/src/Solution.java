//给你一个 n 行 m 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
//每次「迁移」操作将会引发下述活动：
//位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
//位于 grid[i][m - 1] 的元素将会移动到 grid[i + 1][0]。
//位于 grid[n - 1][m - 1] 的元素将会移动到 grid[0][0]。
//请你返回 k 次迁移操作后最终得到的 二维网格。
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int[] array = new int[grid[0].length * grid.length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                k = k % array.length;
                array[k++] = grid[i][j];
            }
        }
        int count = 0;
        List<List<Integer>> list = new ArrayList<>(grid.length);
        for(int i = 0; i < grid.length; i++){
            List<Integer> inList = new ArrayList<>(grid[i].length);
            for(int j = 0; j < grid[i].length; j++){
                inList.add(array[count++]);
            }
            list.add(inList);
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};
        Solution s = new Solution();
        s.shiftGrid(a, 1);
    }
}
