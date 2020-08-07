/*回文索引
题目描述:
给定一个仅由小写字母组成的字符串。现在请找出一个位置，删掉那个字母之后，字符串变成回文。
请放心总会有一个合法的解。如果给定的字符串已经是一个回文串，那么输出-1。

输入描述:
第一行包含T，测试数据的组数。后面跟有T行，每行包含一个字符串。

输出描述:
如果可以删去一个字母使它变成回文串，则输出任意一个满足条件的删去字母的位置（下标从0开始）。例如：
bcc
我们可以删掉位置0的b字符。
 */
import java.util.Scanner;

public class PalindromeIndex {
    private static boolean isPalin(String s, int[] start, int[] end){
        int left = 0, right = s.length() - 1;
        boolean flag = true;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                flag = false;
                break;
            }
            left++;
            right--;
        }
        if(start != null) start[0] = left;
        if(end != null) end[0] = right;
        return flag;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] arr = new String[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.next();
        }

        for(int i = 0; i < n; i++){
            int[] start = new int[1];
            int[] end = new int[2];
            if(isPalin(arr[i], start, end)){
                System.out.println(-1);
            }else{
                StringBuilder str = new StringBuilder(arr[i]);
                str.deleteCharAt(start[0]);
                if(isPalin(str.toString(), null, null)){
                    System.out.println(start[0]);
                }else{
                    System.out.println(end[0]);
                }
            }
        }
    }
}
