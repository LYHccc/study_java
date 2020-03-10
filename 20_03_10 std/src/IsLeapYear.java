//闰年判断
import java.util.Scanner;

public class IsLeapYear {
    public static boolean isLeap(int year){
        if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        if(isLeap(year)){
            System.out.println("yes");
        }
        if(!isLeap(year)){
            System.out.println("no");
        }
    }
}
