/*个位数统计
题目描述：
输入一个长度不超过1000的整数，返回每一位数字:出现的次数，从小到大的顺序输出

输入：
100322

输出：
0:2
1:1
2:2
3:1
 */
import java.util.Scanner;

public class SingleDigitStatistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String s = scanner.nextLine();
            int[] arr = new int[10];
            for(char c : s.toCharArray()){
                arr[c - '0']++;
            }
            for(int i = 0; i < 10; i++){
                if(arr[i] != 0){
                    System.out.println(i + ":" + arr[i]);
                }
            }
        }
    }
}
