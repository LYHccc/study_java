/*被围绕的区域
给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 */
public class SurroundArea {
    private static final int[][] position = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private void dfs(char[][] board, int row, int col, int x, int y){
        board[x][y] = 'A';
        for(int i = 0; i < 4; i++){
            int newX = x + position[i][0];
            int newY = y + position[i][1];
            if(newX < 0 || newX >= row || newY < 0 || newY >= col){
                continue;
            }
            if(board[newX][newY] == 'O'){
                dfs(board, row, col, newX, newY);
            }
        }
    }

    public void solve(char[][] board) {
        if(board.length == 0 || board[0].length == 0) return;
        int row = board.length;
        int col = board[0].length;
        for(int i = 0; i < row; i++){
            if(board[i][0] == 'O'){
                dfs(board, row, col, i, 0);
            }
            if(board[i][col - 1] == 'O'){
                dfs(board, row, col, i, col - 1);
            }
        }
        for(int i = 0; i < col; i++){
            if(board[0][i] == 'O'){
                dfs(board, row, col, 0, i);
            }
            if(board[row - 1][i] == 'O'){
                dfs(board, row, col, row - 1, i);
            }
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == 'A'){
                    board[i][j] = 'O';
                }
            }
        }
    }
}
