/*单调栈结构
给定一个不含有重复值的数组 arr，找到每一个 i 位置左边和右边离 i 位置最近且值比 arr[i] 小的位置。
返回所有位置相应的信息。

输入描述:
第一行输入一个数字 n，表示数组 arr 的长度。
以下一行输出 n个数字，表示数组的值。

输出描述:
输出n行，每行两个数字 L 和 R，如果不存在，则值为-1，下标从0开始。
 */
import java.util.Scanner;

public class MonotonyStackConstruction {
    private static void print(int[] arr, int index){
        int num = arr[index];
        int res = -1;
        for(int i = index - 1; i >= 0; i--){
            if(num > arr[i]){
                res = i;
                break;
            }
        }
        System.out.print(res + " ");

        res = -1;
        for(int i = index + 1; i < arr.length; i++){
            if(num > arr[i]){
                res = i;
                break;
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }

        for(int i = 0; i < n; i++){
            print(arr, i);
        }
    }
}
