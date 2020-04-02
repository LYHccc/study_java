/*买苹果
题目描述:
小易去附近的商店买苹果，奸诈的商贩使用了捆绑交易，只提供6个每袋和8个每袋的包装(包装不可拆分)。 可是小易现在只想购买恰好n个苹果，小易想购买尽量少的袋数方便携带。如果不能购买恰好n个苹果，小易将不会购买。
输入描述:
输入一个整数n，表示小易想购买n(1 ≤ n ≤ 100)个苹果
输出描述:
输出一个整数表示最少需要购买的袋数，如果不能买恰好n个苹果则输出-1
 */
import java.util.Scanner;

public class BuyApple {
    /*
    方法一：
    private static int count(int n){
        if(n % 8 == 0){
            return n / 8;
        }
        int index = 1;
        int num = n;
        while(num > 0){
            int i = index;
            num = n;
            while(i > 0){
                num -= 6;
                i--;
            }
            if(num % 8 == 0){
                break;
            }
            index++;
        }
        int count = (n - index * 6) / 8 + index;
        return num >= 0 ? count : -1;
    }
    */

    //方法二：6和8可以组成十以上的任意一个偶数，
    //如果 n % 8 = 2的话(例18 = 8 + 8 + 2 = 6 + 6 + 6)，从前边的两个8中拿出2补到后边凑出6
    //如果 n % 8 = 4的话(例20 = 8 + 8 + 4 = 8 + 6 + 6)，从前边的一个8中取出2补到后边凑出6
    //如果 n % 8 = 6的话，不用补
    //可以看到在 n / 8 后再+ 1 可以满足所有条件
    private static int count(int n){
        if(n % 2 != 0 || n == 10 || n < 6){
            return -1;
        }
        if(n % 8 == 0){
            return n / 8;
        }
        return n / 8 + 1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(count(num));
    }
}
