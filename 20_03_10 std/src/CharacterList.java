//给出n个数，找出这n个数的最大值，最小值，和。
import java.util.Scanner;

public class CharacterList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            int temp = scanner.nextInt();
            arr[i] = temp;
        }
        int max = arr[0];
        int min = arr[0];
        int sum = arr[0];
        for(int i = 1; i < n; i++){
            max = Math.max(arr[i], max);
            min = Math.min(arr[i], min);
            sum += arr[i];
        }
        System.out.println(max);
        System.out.println(min);
        System.out.println(sum);
    }
}
