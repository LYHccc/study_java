/**
 * 字符串过滤
 * 字符串中间的多余一个的下划线被称为“多余下划线”，请将源字符串中的多余字符串删除
 * 字符串前后的下划线全部删掉
 */

import java.util.Scanner;

public class Main3 {
    private static String delete(String s){
        boolean flag = true;
        StringBuilder str = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c == '_' && flag){
                flag = false;
                str.append(c);
            }else if(c == '_' && !flag){
                continue;
            }else{
                str.append(c);
                flag = true;
            }
        }
        for(int i = str.length() - 1; i >= 0; i--){
            if(str.charAt(i) != '_')
                break;
            str.deleteCharAt(str.length() - 1);
        }
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != '_')
                break;
            str.deleteCharAt(0);
        }
        return str.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(delete(s));
    }
}
