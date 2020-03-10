//给出一个包含n个整数的数列，问整数a在数列中的第一次出现是第几个。
//第一行包含一个整数n。
//第二行包含n个非负整数，为给定的数列，数列中的每个数都不大于10000。
//第三行包含一个整数a，为待查找的数。
import java.util.Scanner;

public class SearchNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            int num = scanner.nextInt();
            arr[i] = num;
        }
        int search = scanner.nextInt();
        int result = -1;
        for(int i = 0; i < n; i++){
            if(arr[i] == search){
                result = i + 1;
                break;
            }
        }
        System.out.println(result);
    }
}
