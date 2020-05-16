/*字母统计
题目描述：
输入一行字符串，计算其中A-Z大写字母出现的次数

输入描述:
案例可能有多组，每个案例输入为一行字符串。

输出描述:
对每个案例按A-Z的顺序输出其中大写字母出现的次数。
 */
import java.util.Scanner;

public class CharStatistics {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String s = scanner.nextLine();
            int[] arr = new int[26];
            for(char c : s.toCharArray()){
                if(c >= 'A' && c <= 'Z'){
                    arr[c - 'A']++;
                }
            }
            for(int i = 0; i < arr.length; i++){
                char c = (char)(i + 'A');
                System.out.println(c + ":" + arr[i]);
            }
        }
    }
}
