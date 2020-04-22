/*统计每个月兔子的总数
有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，问每个月的兔子总数为多少？
输入描述:
输入int型表示month

输出描述:
输出兔子总数int型
 */
import java.util.Scanner;

public class RabbitNumber {
    private static int getTotalCount(int monthCount){
        if(monthCount == 1 || monthCount == 2){
            return 1;
        }
        if(monthCount == 3){
            return 2;
        }
        return getTotalCount(monthCount - 1) + getTotalCount(monthCount - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()) {
            int month = scanner.nextInt();
            System.out.println(getTotalCount(month));
        }
    }
}
