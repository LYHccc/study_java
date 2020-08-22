/**
 * 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
import java.util.ArrayList;
import java.util.List;

public class Combine {
    private void dfs(List<List<Integer>> list, List<Integer> temp, int[] arr, int index, int k){
        if(k == 0){
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i = index; i < arr.length; i++){
            temp.add(arr[i]);
            dfs(list, temp, arr, i + 1, k - 1);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = i + 1;
        }
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(list, temp, arr, 0, k);
        return list;
    }
}
