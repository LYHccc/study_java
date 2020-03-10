//输出杨辉三角前 n 行 1 <= n <= 34
//输出杨辉三角形的前n行。每一行从这一行的第一个数开始依次输出，中间使用一个空格分隔。请不要在前面输出多余的空格。
import java.util.Scanner;

public class YHTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++){
            arr[i][0] = 1;
        }
        System.out.println(arr[0][0]);
        for(int i = 1; i < n; i++){
            System.out.print(arr[i][0] + " ");
            for(int j = 1; j <= i; j++){
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
