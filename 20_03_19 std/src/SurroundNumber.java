/*
回形取数
问题描述
　　回形取数就是沿矩阵的边取数，若当前方向上无数可取或已经取过，则左转90度。一开始位于矩阵左上角，方向向下。

输入格式
　　输入第一行是两个不超过200的正整数m, n，表示矩阵的行和列。接下来m行每行n个整数，表示这个矩阵。

输出格式
　　输出只有一行，共mn个数，为输入矩阵回形取数得到的结果。数之间用一个空格分隔，行末不要有多余的空格。
*/
import java.util.Scanner;

public class SurroundNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int[][] arr = new int[row][col];
        boolean[][] flag = new boolean[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                arr[i][j] = scanner.nextInt();
            }
        }

        int sum = 0;
        int x = -1, y = 0;
        while(sum < row * col){
            while(x + 1 < row && !flag[x + 1][y]){
                System.out.print(arr[++x][y] + " ");
                flag[x][y] = true;
                sum++;
            }
            while(y + 1 < col && !flag[x][y + 1]){
                System.out.print(arr[x][++y] + " ");
                flag[x][y] = true;
                sum++;
            }
            while(x - 1 >= 0 && !flag[x - 1][y]){
                System.out.print(arr[--x][y] + " ");
                flag[x][y] = true;
                sum++;
            }
            while(y - 1 >= 0 && !flag[x][y - 1]){
                System.out.print(arr[x][--y] + " ");
                flag[x][y] = true;
                sum++;
            }
        }
    }
}
