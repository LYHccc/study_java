/*分解质因数
问题描述：
　　求出区间[a,b]中所有整数的质因数分解。
输入格式：
　　输入两个整数a，b。
输出格式：
　　每行输出一个数的分解，形如k=a1*a2*a3...(a1<=a2<=a3...，k也是从小到大的)
 */
import java.util.Scanner;

public class FactorizationPrimeFactor {
    private static boolean isPrime(int n){
        for(int i = 2; i < n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    private static void resolve(int n){
        for(int i = 2; i <= n; i++){
            while(n % i == 0 && n != i){
                System.out.print(i + "*");
                n /= i;
            }
            if(n == i){
                System.out.print(i);
                break;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int left = scanner.nextInt();
        int right = scanner.nextInt();
        for(int i = left; i <= right; i++){
            if(isPrime(i)){
                System.out.println(i + "=" + i);
            }else{
                System.out.print(i + "=");
                resolve(i);
                System.out.println();
            }
        }
    }
}
