/**
 * 字符串匹配
 * 输入一个字符串s1和一个字符串s2,判断s1中包含s2的起始下标
 * 如果不存在返回-1，如果s2为空字符串，返回0
 * 示例输入：abaa baa
 * 输出：1
 */
import java.util.Scanner;

public class Main2 {
    private static int findIndex(String s1, String s2){
        if(s2.length() == 0) return 0;
        if(!s1.contains(s2)){
            return -1;
        }else{
            for(int i = 0; i < s1.length(); i++){
                if(s1.charAt(i) == s2.charAt(0)){
                    if(s1.substring(i, i + s2.length()).equals(s2)){
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();
        System.out.println(findIndex(s1, s2));
    }
}
