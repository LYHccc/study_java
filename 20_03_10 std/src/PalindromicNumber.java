//特殊回文数
//123321是一个非常特殊的数，它从左边读和从右边读是一样的。
//输入一个正整数n， 编程求所有这样的五位和六位十进制数，满足各位数字之和等于n 。
import java.util.Scanner;

public class PalindromicNumber {
    public static boolean isPalindromic(int n, int number){
        int frist = n;
        int temp = 0;
        int num = 0;
        int sum = 0;
        while(n > 0){
            temp = n % 10;
            num = num * 10 + temp;
            sum += temp;
            n /= 10;
        }
        return frist == num && sum == number;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        for(int i = 10000; i < 1000000; i++){
            if(isPalindromic(i, number)){
                System.out.println(i);
            }
        }
    }
}
