/*矩阵乘法
问题描述：
　　给定一个N阶矩阵A，输出A的M次幂（M是非负整数）
　　例如：
　　A =
　　1 2
　　3 4
　　A的2次幂
　　7 10
　　15 22
输入格式：
　　第一行是一个正整数N、M（1<=N<=30, 0<=M<=5），表示矩阵A的阶数和要求的幂数
　　接下来N行，每行N个绝对值不超过10的非负整数，描述矩阵A的值
输出格式：
　　输出共N行，每行N个整数，表示A的M次幂所对应的矩阵。相邻的数之间用一个空格隔开
 */
import java.util.Arrays;
import java.util.Scanner;

public class MatrixMultiplication {
    private static int[][] updateMatrix(int[][] newArr, int[][] arr){
        int len = arr.length;
        int[][] temp = new int[len][len];
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                for(int k = 0; k < len; k++){
                    temp[i][j] += arr[i][k] * newArr[k][j];
                }
            }
        }
        return temp;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = scanner.nextInt();
            }
        }
        int[][] newArr = new int[n][n];
        if(m == 0){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(i == j){
                        newArr[i][j] = 1;
                    }
                }
            }
        }else{
            newArr = Arrays.copyOf(arr, n);
            for(int i = 0; i < m - 1; i++){
                newArr = updateMatrix(newArr, arr);
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(newArr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
