/*守形数
题目描述：
守形数是这样一种整数，它的平方的低位部分等于它本身。
比如25的平方是625，低位部分是25，因此25是一个守形数。 编一个程序，判断N是否为守形数。

输入描述:
输入包括1个整数N，2<=N<100。

输出描述:
可能有多组测试数据，对于每组数据，
输出"Yes!”表示N是守形数。
输出"No!”表示N不是守形数。
 */
import java.util.Scanner;

public class NumberOfKeepShape {
    private static boolean isNumber(int n, int num){
        int temp = n;
        int res = 0;
        int count = 0;
        while(temp != 0){
            temp /= 10;
            res += (num % 10) * Math.pow(10, count);
            num /= 10;
            count++;
        }
        if(res == n){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            int n = scanner.nextInt();
            int num = n * n;
            if(isNumber(n, num)){
                System.out.println("Yes!");
            }else{
                System.out.println("No!");
            }
        }
    }
}
