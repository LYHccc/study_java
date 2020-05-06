/*字符串合并
问题描述:
　　输入两个字符串，将其合并为一个字符串后输出。
输入格式:
　　输入两个字符串
输出格式:
　　输出合并后的字符串
 */
import java.util.Scanner;

public class StringMerge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        StringBuilder str = new StringBuilder();
        str.append(s1).append(s2);
        System.out.println(str.toString());
    }
}
