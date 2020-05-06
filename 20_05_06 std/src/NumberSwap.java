/*数据交换
问题描述:
　　编写一个程序，输入两个整数，分别存放在变量x和y当中，然后使用自己定义的函数swap来交换这两个变量的值。
　　输入格式：输入只有一行，包括两个整数。
　　输出格式：输出只有一行，也是两个整数，即交换以后的结果。
　　要求：主函数负责数据的输入与输出，但不能直接交换这两个变量的值，
    必须通过调用单独定义的函数swap来完成，而swap函数只负责交换变量的值，不能输出交换后的结果。
 */
import java.util.Scanner;

public class NumberSwap {
    private static int a, b;
    private static void swap(){
        int t = a;
        a = b;
        b = t;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();
        swap();
        System.out.print(a + " " + b);
    }
}
