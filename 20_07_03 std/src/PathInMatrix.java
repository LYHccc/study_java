/*矩阵中的路径
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
例如 ：
[a, b, c, e]
[s, f, c, s]
[a, d, e, e]
矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class PathInMatrix {
    private static int[][] position = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static boolean[] visited;

    private static boolean dfs(char[] matrix, int row, int col, char[] str, int curRow, int curCol, int count){
        int index = curRow * col + curCol;
        if(matrix[index] != str[count] || visited[index])
            return false;
        visited[index] = true;
        if(count == str.length - 1)
            return true;
        for(int i = 0;  i < 4; i++){
            int x = curRow + position[i][0];
            int y = curCol+ position[i][1];
            if(x < 0 || x >= row || y < 0 || y >= col)
                continue;
            if(dfs(matrix, row, col, str, x, y, count + 1)){
                return true;
            }
        }
        visited[index] = false;
        return false;
    }

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        visited = new boolean[matrix.length];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(dfs(matrix, rows, cols, str, i, j, 0)){
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String s1 = "ABCESFCSADEE";
        String s2 = "ABCB";
        System.out.println(hasPath(s1.toCharArray(), 3, 4, s2.toCharArray()));
    }
}
