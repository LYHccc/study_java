//给定一个整数矩阵，找出最长递增路径的长度。
//对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外。

public class LongestIncreasingPath {
    final int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};//控制数组中某个位置的数字下次移动的方向({0,1}是向右移动，{1,0}是向下移动，其余两个是相反的方向)具体看代码理解
    int row, list;//数组的行和列
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0) return 0;//如果数组为空即一行元素也没有
        row = matrix.length;//行数
        list = matrix[0].length;//列数
        int maxLen = 0;//当前最长递增路径长度
        int[][] cache = new int[row][list];//用来记录某一个位置从它开始的最长递增路径的值
        for(int i = 0; i < row; i++){
            for(int j = 0; j < list; j++){
                maxLen = Math.max(maxLen, dfs(matrix, i, j, cache));//调用dfs函数找出每一个位置的数字从它开始的最长递增路径的长度，找出其中的最大值
            }
        }
        return maxLen;
    }

    public int dfs(int[][] matrix, int i, int j, int[][] cache){
        if(cache[i][j] != 0) return cache[i][j];//如果当前位置的最长递增路径已经找到过了，直接返回以前找到的值
        for(int[] a : dir){
            int x = i + a[0];//行的移动
            int y = j + a[1];//列的移动
            if(x >= 0 && x < row && y >=0 && y < list && matrix[x][y] > matrix[i][j]){//如果移动后没有出边界，并且满足递增的条件
                cache[i][j] = Math.max(cache[i][j], dfs(matrix, x, y, cache));//找出指定位置向不同方向移动的最长递增路径的最大值
            }
        }
        cache[i][j]++;
        return cache[i][j];
    }
}
