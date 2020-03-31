/*猴子吃包子
问题描述：
　　从前，有一只吃包子很厉害的猴子，它可以吃无数个包子，但是，它吃不同的包子速度也不同；肉包每秒钟吃x个；韭菜包每秒钟吃y个；没有馅的包子每秒钟吃z个；现在有x1个肉包，y1个韭菜包，z1个没有馅的包子；问：猴子吃完这些包子要多久？结果保留p位小数。
输入格式：
　　输入1行，包含7个整数，分别表示吃不同包子的速度和不同包子的个数和保留的位数。
输出格式：
　　输出一行，包含1个实数，表示吃完所有包子的时间。
 */
import java.util.Scanner;

public class MonkeysEatBuns {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] speed = new int[3];
        int[] num = new int[3];
        for(int i = 0; i < 3; i++){
            speed[i] = scanner.nextInt();
        }
        for(int i = 0; i < 3; i++){
            num[i] = scanner.nextInt();
        }
        int flag = scanner.nextInt();
        double time = 0;
        for(int i = 0; i < 3; i++){
            time += num[i] * 1.0 / speed[i];
        }
        System.out.printf("%." + flag + "f", time);
    }
}
