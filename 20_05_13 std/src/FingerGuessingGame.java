/*剪刀石头布
大家应该都会玩“锤子剪刀布”的游戏：
现给出两人的交锋记录，请统计双方的胜、平、负次数，并且给出双方分别出什么手势的胜算最大。

输入描述:
输入第1行给出正整数N（<=105），即双方交锋的次数。随后N行，每行给出一次交锋的信息，
即甲、乙双方同时给出的的手势。C代表“锤子”、J代表“剪刀”、B代表“布”，
第1个字母代表甲方，第2个代表乙方，中间有1个空格。

输出描述:
输出第1、2行分别给出甲、乙的胜、平、负次数，数字间以1个空格分隔。
第3行给出两个字母，分别代表甲、乙获胜次数最多的手势，中间有1个空格。
如果解不唯一，则输出按字母序最小的解。
 */
import java.util.Scanner;

public class FingerGuessingGame {
    private static int[] a = new int[3];
    private static int[] b = new int[3];
    private static int[] winA = new int[3];
    private static int[] winB = new int[3];

    private static void setResult(char c1, char c2){
        if(c1 == 'C'){
            if(c2 == 'C'){
                a[1]++;
                b[1]++;
            }else if(c2 == 'J'){
                a[0]++;
                b[2]++;
                winA[1]++;
            }else{
                a[2]++;
                b[0]++;
                winB[0]++;
            }
        }else if(c1 == 'J'){
            if(c2 == 'J'){
                a[1]++;
                b[1]++;
            }else if(c2 == 'B'){
                a[0]++;
                b[2]++;
                winA[2]++;
            }else{
                a[2]++;
                b[0]++;
                winB[1]++;
            }
        }else{
            if(c2 == 'B'){
                a[1]++;
                b[1]++;
            }else if(c2 == 'C'){
                a[0]++;
                b[2]++;
                winA[0]++;
            }else{
                a[2]++;
                b[0]++;
                winB[2]++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int  i = 0; i < n; i++){
            char c1 = scanner.next().charAt(0);
            char c2 = scanner.next().charAt(0);
            setResult(c1, c2);
        }
        System.out.println(a[0] + " " + a[1] + " " + a[2]);
        System.out.println(b[0] + " " + b[1] + " " + b[2]);
        int max1 = 0, max2 = 0;
        for(int i = 1; i < 3; i++){
            if(winA[i] > winA[max1]){
                max1 = i;
            }
            if(winB[i] > winB[max2]){
                max2 = i;
            }
        }
        char[] res = {'B', 'C', 'J'};
        System.out.println(res[max1] + " " + res[max2]);
    }
}
