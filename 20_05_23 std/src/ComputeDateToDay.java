/*计算日期到天数转换
题目描述
根据输入的日期，计算是这一年的第几天。。
详细描述：
输入某年某月某日，判断这一天是这一年的第几天？。

输入描述:
输入三行，分别是年，月，日

输出描述:
成功:返回outDay输出计算后的第几天;
失败:返回-1
 */
import java.util.Scanner;

public class ComputeDateToDay {
    private static int[] arr = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static boolean isLeap(int year){
        if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
            return true;
        }

        return false;
    }

    private static int dateToDay(int year, int month, int day){
        int sum = 0;
        if(!isLeap(year)){
            arr[2] = 28;
            for(int i = 1; i < month; i++){
                sum+= arr[i];
            }
            sum+= day;
        }else{
            arr[2] = 29;
            for(int i = 1; i < month; i++){
                sum+= arr[i];
            }
            sum+= day;
        }

        return sum;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()) {
            int year = scanner.nextInt();
            int month = scanner.nextInt();
            int day = scanner.nextInt();
            System.out.println(dateToDay(year, month, day));
        }
    }
}
