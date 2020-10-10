/**
 * 特别数的和
 * 小明对数位中含有 2、0、1、9 的数字很感兴趣（不包括前导 0），
 * 在 1 到 40 中这样的数包括 1、2、9、10 至 32、39 和 40，共 28 个，他们的和是 574。
 * 请问，在 1 到 n 中，所有这样的数的和是多少？
 * 【输入格式】
 * 输入一行包含两个整数 n。
 * 【输出格式】
 * 输出一行，包含一个整数，表示满足条件的数的和。
 */
package Test;

import java.util.Scanner;

public class Main3 {
    private static boolean include(int num){
        while(num > 0){
            int temp = num % 10;
            if(temp == 2 || temp == 0 || temp == 9 || temp == 1){
                return true;
            }
            num /= 10;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        int res = 0;
        for(int i = start; i <= end; i++){
            if(include(i)){
                res += i;
            }
        }
        System.out.println(res);
    }
}
