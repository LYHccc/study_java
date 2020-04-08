/*末尾0的个数
题目描述：
输入一个正整数n,求n!(即阶乘)末尾有多少个0？ 比如: n = 10; n! = 3628800,所以答案为2

输入描述:
输入为一行，n(1 ≤ n ≤ 1000)

输出描述:
输出一个整数,即题目所求
 */
import java.math.BigInteger;
import java.util.Scanner;

public class TheNumberOfZeroAtTheEnd {
    private static BigInteger fac(int n){
        String temp = "";
        BigInteger big = new BigInteger("1");
        for(int i = 1; i <= n; i++){
            temp = Integer.toString(i);
            BigInteger big2 = new BigInteger(temp);
            big = big.multiply(big2);
        }
        return big;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = fac(n).toString();
        int count = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) != '0'){
                break;
            }
            count++;
        }
        System.out.println(count);
    }
}
