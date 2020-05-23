/*字符串加解密
题目描述
1、对输入的字符串进行加解密，并输出。
2加密方法为：
当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；
当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；
其他字符不做变化。
3、解密方法为加密的逆过程。

输入描述:
输入一串要加密的密码
输入一串加过密的密码

输出描述:
输出加密后的字符
输出解密后的字符
 */
import java.util.Scanner;

public class EncryptionAndDecode {
    private static boolean isBig(char c){
        return (c >= 'A' && c <= 'Z');
    }
    private static boolean isSmall(char c){
        return (c >= 'a' && c <= 'z');
    }
    private static boolean isNumber(char c){
        return (c >='0' && c <= '9');
    }

    //加密
    private static String encryption(String s){
        StringBuilder str = new StringBuilder();
        for(char c : s.toCharArray()){
            if(isBig(c)){
                if(c == 'Z'){
                    c = 'A';
                }else{
                    c += 1;
                }
                c = Character.toLowerCase(c);
            }else if(isSmall(c)){
                if(c == 'z'){
                    c = 'a';
                }else{
                    c += 1;
                }
                c = Character.toUpperCase(c);
            }else if(isNumber(c)){
                if(c == '9'){
                    c = '0';
                }else{
                    c += 1;
                }
            }
            str.append(c);
        }
        return str.toString();
    }

    //解密
    private static String decode(String s){
        StringBuilder str = new StringBuilder();
        for(char c : s.toCharArray()){
            if(isBig(c)){
                if(c == 'A'){
                    c = 'Z';
                }else{
                    c -= 1;
                }
                c = Character.toLowerCase(c);
            }else if(isSmall(c)){
                if(c == 'a'){
                    c = 'z';
                }else{
                    c -= 1;
                }
                c = Character.toUpperCase(c);
            }else if(isNumber(c)){
                if(c == '0'){
                    c = '9';
                }else{
                    c -= 1;
                }
            }
            str.append(c);
        }
        return str.toString();
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            String source = scanner.nextLine();
            String change = scanner.nextLine();
            System.out.println(encryption(source));
            System.out.println(decode(change));
        }
    }
}
