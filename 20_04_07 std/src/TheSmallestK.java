/*n个数里最小的k个
题目描述：
找出n个数里最小的k个

输入描述:
每个测试输入包含空格分割的n+1个整数，最后一个整数为k值,n不超过100。

输出描述:
输出n个整数里最小的k个数。升序输出
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TheSmallestK {
    /*方法一：大跟堆找到最小的k个
    private static int[] foundSmall(int[] arr, int k){
        int[] temp = new int[k];
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(int a : arr){
            queue.offer(a);
            if(queue.size() > k){
                queue.poll();
            }
        }
        int index = 0;
        while(!queue.isEmpty()){
            temp[index++] = queue.poll();
        }
        Arrays.sort(temp);
        return temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] sArr = s.split(" ");
            int[] arr = new int[sArr.length - 2];
            for (int i = 0; i < sArr.length - 2; i++) {
                arr[i] = Integer.parseInt(sArr[i]);
            }
            int k = Integer.parseInt(sArr[sArr.length - 1]);
            for (int a : foundSmall(arr, k)) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
    */

    //方法二：排序
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] sArr = s.split(" ");
            int[] arr = new int[sArr.length - 2];
            for (int i = 0; i < sArr.length - 2; i++) {
                arr[i] = Integer.parseInt(sArr[i]);
            }
            int k = Integer.parseInt(sArr[sArr.length - 1]);
            Arrays.sort(arr);
            for(int i = 0; i < k; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
