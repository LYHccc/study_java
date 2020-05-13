/*上楼梯
题目描述
有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶、3阶。
请实现一个方法，计算小孩有多少种上楼的方式。为了防止溢出，请将结果Mod 1000000007
给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。
 */
import java.util.Scanner;

public class GoUpStairs {
    public static int countWays(int n) {
        long[] arr = new long[100001];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        for(int i = 4; i <= n; i++){
            arr[i] = (arr[i - 1] + arr[i - 2] + arr[i - 3]) % 1000000007;
        }
        return (int)arr[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()) {
            int n = scanner.nextInt();
            System.out.println(countWays(n));
        }
    }
}
