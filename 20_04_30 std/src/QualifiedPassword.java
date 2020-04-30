/*密码验证合格程序
题目描述
密码要求:
1.长度超过8位
2.包括大小写字母.数字.其它符号,以上四种至少三种
3.不能有相同长度超过2的子串重复

输入描述:
一组或多组长度超过2的子符串。每组占一行

输出描述:
如果符合要求输出：OK，否则输出NG
 */
import java.util.HashSet;
import java.util.Scanner;

public class QualifiedPassword {
    private static boolean flag;
    private static void isInclude(String s){
        int a1 = 0, a2 = 0, a3 = 0, a4 = 0;
        for(char c : s.toCharArray()){
            if(c >= '0' && c <= '9'){
                a1 = 1;
            }else if(c >= 'a' && c <= 'z'){
                a2 = 1;
            }else if(c >= 'A' && c <= 'Z'){
                a3 = 1;
            }else{
                a4 = 1;
            }
        }
        int sum = a1 + a2 + a3 + a4;
        if(sum < 3){
            flag = false;
        }
    }

    private static void isRepetition(String s){
        HashSet<String> set = new HashSet<>();
        int len = s.length();
        for(int i = 0; i < len - 3; i++){
            String str = s.substring(i, i + 3);
            if(!set.add(str)){
                flag = false;
            }
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String s = scanner.nextLine();
            flag = true;
            if(s.length() <= 8){
                flag = false;
            }
            isInclude(s);
            isRepetition(s);
            if(flag){
                System.out.println("OK");
            }else{
                System.out.println("NG");
            }
        }
    }
}
