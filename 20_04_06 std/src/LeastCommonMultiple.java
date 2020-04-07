/*求最小公倍数
题目描述:
正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。

输入描述:
输入两个正整数A和B。

输出描述:
输出A和B的最小公倍数。
 */
import java.util.Scanner;

public class LeastCommonMultiple {
    private static int leastCommomMultiple(int a, int b){
        int max = Math.max(a, b);
        while(true){
            if(max % a == 0 && max % b == 0){
                return max;
            }
            max++;
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        System.out.println(leastCommomMultiple(A, B));
    }
}
