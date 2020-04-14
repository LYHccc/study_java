/*尼科彻斯定理
验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
例如：
1^3=1
2^3=3+5
3^3=7+9+11
4^3=13+15+17+19

输入描述:
输入一个int整数

输出描述:
输出分解后的string
 */
import java.util.Scanner;

public class 尼科彻斯定理 {
    private static String GetSequeOddNum(int n){
        StringBuilder str = new StringBuilder();
        int start = n * (n - 1) + 1;
        for(int i = 0; i < n; i++){
            str.append(start).append("+");
            start += 2;
        }
        str.deleteCharAt(str.length() - 1);
        return str.toString();
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(GetSequeOddNum(n));
    }
}
