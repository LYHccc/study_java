/*找x
题目描述：
输入一个数n，然后输入n个数值各不相同，再输入一个值x，
输出这个值在这个数组中的下标（从0开始，若不在数组中则输出-1）。

输入描述:
测试数据有多组，输入n(1<=n<=200)，接着输入n个数，然后输入x。

输出描述:
对于每组输入,请输出结果。
 */
import java.util.Scanner;

public class FindX {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = scanner.nextInt();
            }
            int x = scanner.nextInt();

            int res = -1;
            for(int i = 0; i < n; i++){
                if(arr[i] == x){
                    res = i;
                    break;
                }
            }

            System.out.println(res);
        }
    }
}
