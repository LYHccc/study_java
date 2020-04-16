/*统计同成绩的学生人数
题目描述:
读入N名学生的成绩，将获得某一给定分数的学生人数输出。

输入描述:
测试输入包含若干测试用例，每个测试用例的格式为
第1行：N
第2行：N名学生的成绩，相邻两数字用一个空格间隔。
第3行：给定分数
当读到N=0时输入结束。其中N不超过1000，成绩分数为（包含）0到100之间的一个整数。

输出描述:
对每个测试用例，将获得给定分数的学生人数输出。
 */
import java.util.Scanner;

public class StatisticsNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if(n == 0) break;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            int score = scanner.nextInt();
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] == score) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
