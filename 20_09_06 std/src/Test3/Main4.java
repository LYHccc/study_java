/**
 * 中位数
 * 给定n个数字，a1,a2...an,n为偶数
 * 找到分别从1到n删除该位置的数字的话，数组中的中位数
 */
package Test3;

import java.util.Arrays;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//元素个数
        int[] arr  = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        int[] temp = Arrays.copyOfRange(arr, 0, n);
        Arrays.sort(temp);
        int mid1 = temp[n / 2];
        int mid2 = temp[n / 2 - 1];
        for(int i = 0; i < n; i++){
            if(arr[i] >= mid1){
                System.out.println(mid2);
            }else{
                System.out.println(mid1);
            }
        }
    }
}
