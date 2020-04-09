/*机器人走方格Ⅰ
题目描述
有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。请设计一个算法，计算机器人有多少种走法。

给定两个正整数int x,int y，请返回机器人的走法数目。保证x＋y小于等于12。
 */
import java.util.Scanner;

public class RobotSquare {
    private static int count(int x, int y){
        if(x == 0 || y == 0){
            return 1;
        }
        return count(x - 1,y) + count(x, y - 1);
    }

    public static int countWays(int x, int y) {
        return count(x - 1, y - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        System.out.println(countWays(row, col));
    }
}
