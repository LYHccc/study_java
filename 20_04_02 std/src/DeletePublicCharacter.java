/*删除公共字符
题目描述:
输入两个字符串，从第一字符串中删除第二个字符串中所有的字符。例如，输入”They are students.”和”aeiou”，则删除之后的第一个字符串变成”Thy r stdnts.”
输入描述:
每个测试输入包含2个字符串
输出描述:
输出删除后的字符串
 */
import java.util.HashSet;
import java.util.Scanner;

public class DeletePublicCharacter {
    private static String deleteCharaccter(String init, String delete){
        StringBuilder str = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        str.append(init);
        for(char c : delete.toCharArray()){
            set.add(c);
        }

        int index = 0;
        while(index < str.length()){
            if(set.contains(str.charAt(index))){
                str.deleteCharAt(index);
                continue;
            }
            index++;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        System.out.println(deleteCharaccter(s1, s2));
    }
}
