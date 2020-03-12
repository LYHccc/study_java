//高精度阶乘计算
import java.util.Scanner;

public class BigIntegerFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[4000];
        arr[0] = 1;
        int carry = 0;
        for(int i = 2; i <= n; i++){
            for(int j = 0; j < arr.length; j++){
                carry = arr[j] * i + carry;
                arr[j] = carry % 10;
                carry /= 10;
            }
        }
        boolean flag = false;
        for(int i = arr.length - 1; i >= 0; i--){
            if(arr[i] != 0 && flag == false){
                flag = true;
            }
            if(flag){
                System.out.print(arr[i]);
            }
        }
    }
}
