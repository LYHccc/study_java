/*完美的代价
问题描述：
　　回文串，是一种特殊的字符串，它从左往右读和从右往左读是一样的。小龙龙认为回文串才是完美的。现在给你一个串，它不一定是回文的，请你计算最少的交换次数使得该串变成一个完美的回文串。
　　交换的定义是：交换两个相邻的字符
　　例如mamad
　　第一次交换 ad : mamda
　　第二次交换 md : madma
　　第三次交换 ma : madam (回文！完美！)
输入格式：
　　第一行是一个整数N，表示接下来的字符串的长度(N <= 8000)
　　第二行是一个字符串，长度为N.只包含小写字母
输出格式：
　　如果可能，输出最少的交换次数。
　　否则输出Impossible
 */
import java.util.Scanner;

public class PriceOfPerfection {
    public static int minChange(char[] c, int len, char only){
        int count = 0, left = 0, right = len - 1;
        while(left < len / 2){
            if(c[left] == only){
                int index = left;
                while(index < right){
                    if(c[index] == c[right]){
                        break;
                    }
                    index++;
                }
                char temp = c[index];
                for(int i = index; i > left; i--){
                    c[i] = c[i - 1];
                }
                c[left] = temp;
                count += index - left;
                right--;
                left++;
            }else{
                int index = right;
                while(index > left){
                    if(c[index] == c[left]){
                        break;
                    }
                    index--;
                }
                char temp = c[index];
                for(int i = index; i < right; i++){
                    c[i] = c[i + 1];
                }
                c[right] = temp;
                count += right - index;
                right--;
                left++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        char[] c = s.toCharArray();
        int[] arr = new int[26];
        for(int i = 0; i < c.length; i++){
            arr[c[i] - 'a']++;
        }
        int count = 0;
        char only = '0';
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % 2 != 0){
                count++;
                only = (char)(i + 'a');
            }
        }
        if(count > 1){
            System.out.println("Impossible");
        }else{
            int result = minChange(c, n, only);
            System.out.println(result);
        }
    }
}
