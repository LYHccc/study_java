/*合唱团
题目描述：
有 n 个学生站成一排，每个学生有一个能力值，牛牛想从这 n 个学生中按照顺序选取 k 名学生，
要求相邻两个学生的位置编号的差不超过 d，使得这 k 个学生的能力值的乘积最大，你能返回最大的乘积吗？

输入描述:
每个输入包含 1 个测试用例。每个测试数据的第一行包含一个整数 n (1 <= n <= 50)，表示学生的个数，
接下来的一行，包含 n 个整数，按顺序表示每个学生的能力值 ai（-50 <= ai <= 50）。
接下来的一行包含两个整数，k 和 d (1 <= k <= 10, 1 <= d <= 50)。

输出描述:
输出一行表示最大的乘积。
 */
import java.util.Scanner;

public class Chorus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            int n = scanner.nextInt();
            int[] arr = new int[n + 1];
            for(int i = 1; i <= n; i++){
                arr[i] = scanner.nextInt();
            }
            int K = scanner.nextInt();
            int d = scanner.nextInt();
            //max[k][n]代表当前共选择了K名同学，最后一个选择的同学为此时的第n个同学，所产生的最大乘积
            //min[k][n]代表当前共选择了K名同学，最后一个选择的同学为此时的第n个同学，所产生的最小乘积
            long[][] max = new long[K + 1][n + 1];
            long[][] min = new long[K + 1][n + 1];
            for(int i = 1; i <= n; i++){
                max[1][i] = arr[i];
                min[1][i] = arr[i];
            }

            for(int k = 2; k <= K; k++){
                for(int i = k; i <= n; i++){//i表示第k个人所处的位置
                    max[k][i] = Long.MIN_VALUE;;
                    min[k][i] = Long.MAX_VALUE;
                    for(int j = Math.max(k - 1, i - d); j <= i - 1; j++){//j表示第k-1个人所处的位置
                        max[k][i] = Math.max(max[k][i], Math.max(max[k - 1][j]*arr[i],min[k - 1][j]*arr[i]));
                        min[k][i] = Math.min(min[k][i], Math.min(max[k - 1][j]*arr[i],min[k - 1][j]*arr[i]));
                    }
                }
            }

            long res = Integer.MIN_VALUE;
            for(int i = K; i <= n; i++){
                res = Math.max(res, max[K][i]);
            }
            System.out.println(res);
        }
    }
}
