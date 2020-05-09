/*奇偶校验
题目描述：
输入一个字符串，然后对每个字符进行奇校验，最后输出校验后的二进制数(如'3’，输出：10110011)。

输入描述:
输入包括一个字符串，字符串长度不超过100。

输出描述:
可能有多组测试数据，对于每组数据，
对于字符串中的每一个字符，输出按题目进行奇偶校验后的数，每个字符校验的结果占一行。
 */
import java.util.Scanner;

public class OddEvenCheck {
    private static int countOne(String s){
        int count = 0;
        for(char c : s.toCharArray()){
            if(c == '1'){
                count++;
            }
        }

        return count;
    }

    private static void check(String s){
        for(char c : s.toCharArray()){
            int temp = (int)c;
            String bin = Integer.toBinaryString(temp);
            StringBuilder str = new StringBuilder();
            str.append(bin);
            int count = countOne(bin);
            int len = str.length();

            if(count % 2 == 1){
                if(len == 8){
                    System.out.println(bin);
                }else{
                    while(str.length() < 8){
                        str.insert(0, "0");
                    }
                    System.out.println(str);
                }
            }else{
                if(len == 8){
                    if(str.charAt(0) == '1'){
                        System.out.println("0" + str.deleteCharAt(0));
                    }else{
                        System.out.println("1" + str.deleteCharAt(0));
                    }
                }else{
                    while(str.length() < 7){
                        str.insert(0, "0");
                    }
                    str.insert(0, "1");
                    System.out.println(str);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String s = scanner.nextLine();
            check(s);
        }
    }
}
