/*数组中值出现了一次的数字
给定一个数字arr，其中只有有两个数字出现了奇数次，其它数字都出现了偶数次，按照从小到大顺序输出这两个数。

输入描述:
输入包含两行，第一行一个整数n(1 \leq n \leq 10^5)(1≤n≤10 5)，代表数组arr的长度，
第二行n个整数，代表数组arr,arr[i]为32位整数。

输出描述:
输出出现奇数次的两个数，按照从小到大的顺序。
 */
import java.util.HashMap;
import java.util.Scanner;

public class AppearOddNumber {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int a : arr){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        int t = 0;
        int m = 0;
        int count = 0;
        for(int a : map.keySet()){
            if(count == 0){
                if(map.get(a) % 2 != 0){
                    t = a;
                    count++;
                }
            }else if(count == 1){
                if(map.get(a) % 2 != 0){
                    m = a;
                    break;
                }
            }
        }

        System.out.println(Math.min(t, m) + " " + Math.max(t, m));
    }
}
