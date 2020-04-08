/*数字颠倒
输入描述:
输入一个int整数

输出描述:
将这个整数以字符串的形式逆序输出
 */
import java.util.Scanner;

public class NumberUpsideDown {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        while(num > 0){
            System.out.print(num % 10);
            num /= 10;
        }
    }
}
