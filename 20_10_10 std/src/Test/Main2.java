/**
 * 数列求和
 * 给定数列 1, 1, 1, 3, 5, 9, 17, …，从第 4 项开始，每项都是前 3 项的和。
 * 求 第 20190324 项的最后 4 位数字。
 */
package Test;

public class Main2 {
    public static void main(String[] args) {
        int[] arr = new int[20190324];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 1;
        for(int i = 3; i < 20190324; i++){
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
        }
        int num = arr[20190323];
        StringBuilder str = new StringBuilder();
        int count = 4;
        while(count > 0){
            str.append(num % 10);
            num /= 10;
            count--;
        }
        System.out.println(str.reverse());
    }
}
