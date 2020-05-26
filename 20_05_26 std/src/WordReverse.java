/*单词倒排
题目描述：
对字符串中的所有单词进行倒排。
说明：
1、构成单词的字符只有26个大写或小写英文字母；
2、非构成单词的字符均视为单词间隔符；
3、要求倒排后的单词间隔符以一个空格表示；如果原字符串中相邻单词间有多个间隔符时，倒排转换后也只允许出现一个空格间隔符；
4、每个单词最长20个字母；

输入描述:
输入一行以空格来分隔的句子

输出描述:
输出句子的逆序
 */
import java.util.Scanner;

public class WordReverse{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String s = scanner.nextLine();
            char[] crr = s.toCharArray();
            for(int i = 0; i < crr.length; i++){
                if(!Character.isLetter(crr[i])){
                    crr[i] = ' ';
                }
            }

            StringBuilder str = new StringBuilder();
            String[] arr = String.valueOf(crr).split(" ");
            for(int i = arr.length - 1; i >= 0; i--){
                if(arr[i].equals("")){
                    continue;
                }else{
                    str.append(arr[i] + " ");
                }
            }

            System.out.println(str.toString().trim());
        }
    }
}