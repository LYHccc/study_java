/*连续最大和
题目描述：
一个数组有 N 个元素，求连续子数组的最大和。 例如：[-1,2,1]，和最大的连续子数组为[2,1]，其和为 3

输入描述:
输入为两行。 第一行一个整数n(1 <= n <= 100000)，表示一共有n个元素 第二行为n个数，即每个元素,每个整数都在32位int范围内。以空格分隔。

输出描述:
所有连续子数组中和最大的值。
 */
import java.util.Scanner;

public class SuccessionSumMax {
    private static int sumMax(int[] arr){
        int len = arr.length;
        int[] temp = new int[len];
        temp[0] = arr[0];
        int minSum = arr[0];
        int maxSub = arr[0];

        for(int i = 1; i < len; i++){
            temp[i] = temp[i - 1] + arr[i];
            int sub = temp[i] - minSum;
            if(sub > maxSub){
                maxSub = sub;
            }

            if(temp[i] < minSum){
                minSum = temp[i];
            }
        }
        return maxSub;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println(sumMax(arr));
    }
}
