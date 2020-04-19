/*DNA序列
题目描述
一个DNA序列由A/C/G/T四个字母的排列组合组成。
G和C的比例（定义为GC-Ratio）是序列中G和C两个字母的总的出现次数除以总的字母数目（也就是序列长度）。
在基因工程中，这个比例非常重要。因为高的GC-Ratio可能是基因的起始点。
给定一个很长的DNA序列，以及要求的最小子序列长度，研究人员经常会需要在其中找出GC-Ratio最高的子序列。

输入描述:
输入一个string型基因序列，和int型子串的长度

输出描述:
找出GC比例最高的子串,如果有多个输出第一个的子串
 */
import java.util.Scanner;

public class DNAList {
    private static String list(String s, int n){
        int left = 0,right = n - 1;
        int start = 0, end = 0;
        int max = 0;

        while(left < s.length() && right < s.length()){
            String temp = s.substring(left, right + 1);
            int count = 0;
            for(char c : temp.toCharArray()){
                if(c == 'G' || c == 'C'){
                    count++;
                }
            }
            if(count > max){
                start = left;
                end = right;
                max = count;
            }
            left++;
            right++;
        }

        return s.substring(start, end + 1);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int n = scanner.nextInt();
        System.out.println(list(s, n));
    }
}
