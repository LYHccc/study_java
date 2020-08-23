/**
 * 股票买卖
 * 股票价格分别为prices[0],prices[1]...prices[n]元
 * 某公司资金m元，财务一共有多少种方法购买股票，使得刚好用完这n元
 * 每股限购一次，输出所有的购买方案
 */
import java.util.ArrayList;
import java.util.Arrays;

public class BuyStocks {
    private static void dfs(ArrayList<ArrayList<Integer>> list, ArrayList<Integer> temp, int[] arr, int m, int index){
        if(m == 0){
            list.add(new ArrayList(temp));
            return;
        }
        for(int i = index; i < arr.length; i++){
            if(m < arr[i])
                break;
            temp.add(arr[i]);
            dfs(list,  temp, arr, m - arr[i], i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static ArrayList<ArrayList<Integer>> combinationSum (int[] prices, int m) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        if(prices.length == 0) return list;
        Arrays.sort(prices);
        dfs(list, temp, prices, m, 0);
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {3, 8, 6};
        System.out.println(combinationSum(arr, 14));
    }
}
