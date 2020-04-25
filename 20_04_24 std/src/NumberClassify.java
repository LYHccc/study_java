/*数字分类
给定一系列正整数，请按要求对数字进行分类，并输出以下5个数字：
A1 = 能被5整除的数字中所有偶数的和；
A2 = 将被5除后余1的数字按给出顺序进行交错求和，即计算n1-n2+n3-n4...；
A3 = 被5除后余2的数字的个数；
A4 = 被5除后余3的数字的平均数，精确到小数点后1位；
A5 = 被5除后余4的数字中最大数字。

输入描述:
每个输入包含1个测试用例。每个测试用例先给出一个不超过1000的正整数N，随后给出N个不超过1000的待分类的正整数。数字间以空格分隔。

输出描述:
对给定的N个正整数，按题目要求计算A1~A5并在一行中顺序输出。数字间以空格分隔，但行末不得有多余空格。
若其中某一类数字不存在，则在相应位置输出“N”。
 */
import java.util.Scanner;

public class NumberClassify {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }

        int sumA1 = 0, sumA2 = 0, sumA4 = 0;
        int symbol2 = 1;
        int numA3 = 0, numA4 = 0;
        int maxA5 = 0;
        boolean flagA1 = false, flagA2 = false, flagA3 = false, flagA4 = false, flagA5 = false;

        for(int a : arr){
            if(a % 5 == 0 && a % 2 == 0){
                sumA1 += a;
                flagA1 = true;
            }
            if(a % 5 == 1){
                sumA2 += a * symbol2;
                symbol2 = -1 * symbol2;
                flagA2 = true;
            }
            if(a % 5 == 2){
                numA3++;
                flagA3 = true;
            }
            if(a % 5 == 3){
                sumA4 += a;
                numA4++;
                flagA4 = true;
            }
            if(a % 5 == 4){
                maxA5 = Math.max(a, maxA5);
                flagA5 = true;
            }
        }

        System.out.print(flagA1 == true ? sumA1 + " ": "N" + " ");
        System.out.print(flagA2 == true ? sumA2 + " ": "N" + " ");
        System.out.print(flagA3 == true ? numA3 + " ": "N" + " ");
        if(flagA4){
            double num = (double)sumA4 / numA4;
            System.out.printf("%.1f", num);
            System.out.print(" ");
        }else{
            System.out.print("N ");
        }
        System.out.print(flagA5 == true ? maxA5 : "N");
    }
}
