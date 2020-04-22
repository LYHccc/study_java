/*密码破译
消息加密的办法是：对消息原文中的每个字母，分别用该字母之后的第5个字母替换
（例如：消息原文中的每个字母A 都分别替换成字母F），其他字符不变，并且消息原文的所有字母都是大写的。
密码中的字母与原文中的字母对应关系如下。
密码字母：A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
原文字母：V W X Y Z A B C D E F G H I J K L M N O P Q R S T U

输入描述:
输入包括多组数据，每组数据一行，为收到的密文。
密文仅有空格和大写字母组成。

输出描述:
对应每一组数据，输出解密后的明文。
 */
import java.util.Scanner;

public class CodeBreaking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            String s = scanner.nextLine();
            StringBuilder str = new StringBuilder();

            for (char c : s.toCharArray()) {
                if(c == ' '){
                    str.append(" ");
                }else {
                    if (c <= 'E') {
                        c += 26;
                    }
                    char temp = (char) (c - 5);
                    str.append(temp);
                }
            }

            System.out.println(str.toString());
        }
    }
}
