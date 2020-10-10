/**
 * 等差数列
 * 数学老师给小明出了一道等差数列求和的题目。但是粗心的小明忘记了一部分的数列，只记得其中N个整数。
 * 现在给出这N个整数，小明想知道包含这N个整数的最短的等差数列有几项?
 */
package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main5 {
    private static List<Integer> getList(int[] arr){
        List<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length - 1; i++){
            int temp = arr[i + 1] - arr[i];
            min = Math.min(min, temp);
        }
        int left = arr[0];
        int right = arr[arr.length - 1];
        while(left <= right){
            list.add(left);
            left += min;
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>(getList(arr));
        System.out.println(list.size());
    }
}
