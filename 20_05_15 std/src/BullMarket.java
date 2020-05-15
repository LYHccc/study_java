/*风口的猪-中国牛市
题目描述
风口之下，猪都能飞。当今中国股市牛市，真可谓“错过等七年”。 给你一个回顾历史的机会，
已知一支股票连续n天的价格走势，以长度为n的整数数组表示，数组中第i个元素（prices[i]）代表该股票第i天的股价。
假设你一开始没有股票，但有至多两次买入1股而后卖出1股的机会，并且买入前一定要先保证手上没有股票。
若两次交易机会都放弃，收益为0。 设计算法，计算你能获得的最大收益。
输入数值范围：2<=n<=100,0<=prices[i]<=100

示例输入：
3,8,5,1,7,8
示例输出：
12
 */
import java.util.Scanner;

public class BullMarket {
    private static int getMax(int[] arr, int left, int right){
        if(left >= arr.length){
            return 0;
        }
        int min = arr[left];
        int sub = 0;
        for(int i = left + 1; i <= right; i++){
            min = Math.min(min, arr[i]);
            sub = Math.max(sub, arr[i] - min);
        }
        return sub;
    }

    public static int calculateMax(int[] prices) {
        int len = prices.length;
        int max = 0;
        for(int i = 0; i < len; i++){
            max = Math.max(max, getMax(prices, 0, i) + getMax(prices, i + 1, len - 1));
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] sArr = s.split(",");
        int[] arr = new int[sArr.length];
        for(int i = 0; i < sArr.length; i++){
            arr[i] = Integer.parseInt(sArr[i]);
        }
        System.out.println(calculateMax(arr));
    }
}
