/*大整数排序
题目描述
对N个长度最长可达到1000的数进行排序。

输入描述:
输入第一行为一个整数N，(1<=N<=100)。
接下来的N行每行有一个数，数的长度范围为1<=len<=1000。
每个数都是一个正数，并且保证不包含前缀零。

输出描述:
可能有多组测试数据，对于每组数据，将给出的N个数从小到大进行排序，输出排序后的结果，每个数占一行。
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BigIntegerSort {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()) {
            int n = scanner.nextInt();
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.next();
            }

            Arrays.sort(arr, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if (o1.length() > o2.length()) {
                        return 1;
                    } else if (o1.length() < o2.length()) {
                        return -1;
                    } else {
                        return o1.compareTo(o2);
                    }
                }
            });

            for (int i = 0; i < n; i++) {
                System.out.println(arr[i]);
            }
        }
    }
}
