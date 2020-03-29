/*Sine之舞
问题描述：
　　最近FJ为他的奶牛们开设了数学分析课，FJ知道若要学好这门课，必须有一个好的三角函数基本功。所以他准备和奶牛们做一个“Sine之舞”的游戏，寓教于乐，提高奶牛们的计算能力。
　　不妨设
　　An=sin(1–sin(2+sin(3–sin(4+...sin(n))...)
　　Sn=(...(A1+n)A2+n-1)A3+...+2)An+1
　　FJ想让奶牛们计算Sn的值，请你帮助FJ打印出Sn的完整表达式，以方便奶牛们做题。
输入格式：
　　仅有一个数：N<201。
输出格式：
　　请输出相应的表达式Sn，以一个换行符结束。输出中不得含有多余的空格或换行、回车符。
 */
import java.util.Scanner;

public class SinceDance {
    static int aindex = 0;
    static int sindex = 0;
    static char flag = '0';
    private static void An(int n){
        aindex++;
        System.out.print("sin(" + aindex);
        if(aindex % 2 == 1){
            flag = '-';
        }else{
            flag = '+';
        }
        if(aindex < n){
            System.out.print(flag);
            An(n);
        }
        System.out.print(")");
    }
    private static void Sn(int n){
        if(n > 1){
            System.out.print("(");
            Sn(n - 1);
            System.out.print(")");
            sindex--;
        }
        aindex = 0;
        An(n);
        System.out.print("+" + sindex);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        sindex = n;
        Sn(n);
    }
}
