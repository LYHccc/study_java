/*句子逆序
题目描述：
将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符

输入描述:
将一个英文语句以单词为单位逆序排放。

输出描述:
得到逆序的句子
 */
import java.util.Scanner;

public class StringRverse {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] arr = s.split(" ");
        StringBuilder str = new StringBuilder();
        for(int i = arr.length - 1; i >= 0; i--){
            str.append(arr[i] + " ");
        }
        str.deleteCharAt(str.length() - 1);
        System.out.println(str.toString());
    }
}
