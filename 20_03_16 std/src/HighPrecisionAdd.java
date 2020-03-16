//输入两个整数a和b，输出这两个整数的和。a和b都不超过100位。
import java.util.Scanner;

public class HighPrecisionAdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] A = new int[100];
        int[] B = new int[100];
        int[] sum = new int[101];
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int index1 = 0;
        int index2 = 0;
        for(int i = s1.length() - 1; i >= 0; i--){
            A[index1++] = s1.charAt(i) - '0';
        }
        for(int i = s2.length() - 1; i >= 0; i--){
            B[index2++] = s2.charAt(i) - '0';
        }
        int carry = 0;
        for(int i = 0; i < 100; i++){
            carry = A[i] + B[i] + carry;
            sum[i] = carry % 10;
            carry /= 10;
        }
        if(carry != 0){
            sum[100] = carry;
        }
        boolean flag = false;
        for(int i = sum.length - 1; i >= 0; i--){
            if(sum[i] != 0){
                flag = true;
            }
            if(flag){
                System.out.print(sum[i]);
                continue;
            }
        }
    }
}