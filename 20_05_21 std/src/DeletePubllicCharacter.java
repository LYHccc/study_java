/*删除公共字符
题目描述：
输入两个字符串，从第一字符串中删除第二个字符串中所有的字符。
例如，输入”They are students.”和”aeiou”，则删除之后的第一个字符串变成”Thy r stdnts.”

输入描述:
每个测试输入包含2个字符串

输出描述:
输出删除后的字符串
 */
import java.util.HashSet;
import java.util.Scanner;

public class DeletePubllicCharacter {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String primary = scanner.nextLine();
            String delete = scanner.nextLine();
            StringBuilder str = new StringBuilder();
            HashSet<Character> set = new HashSet<>();
            for(char c : delete.toCharArray()){
                set.add(c);
            }

            for(char c : primary.toCharArray()){
                if(!set.contains(c)){
                    str.append(c);
                }
            }

            System.out.println(str.toString());
        }
    }
}
