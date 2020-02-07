//输入一个字符串，求出该字符串包含的字符集合
//每组数据输入一个字符串，字符串最大长度为100，且只包含字母，不可能为空串，区分大小写。
//每组数据一行，按字符串原有的字符顺序，输出字符集合，即重复出现并靠后的字母不输出。
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String s = scanner.nextLine();
            StringBuilder str = new StringBuilder();
            for (int index = 0; index < s.length(); index++) {
                if (!str.toString().contains(s.charAt(index) + "")) {
                    str.append(s.charAt(index));
                }
            }
            System.out.println(str.toString());
        }
    }
}