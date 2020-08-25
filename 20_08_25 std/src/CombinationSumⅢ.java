/**
 * 组合总数Ⅲ
 * 找出所有相加之和为n的k个数的组合。组合中只允许含有1-9的正整数，并且每种组合中不存在重复的数字。
 * 说明：
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 */
import java.util.ArrayList;
import java.util.List;

public class CombinationSumⅢ {
    private void dfs(List<List<Integer>> list, List<Integer> temp, int index, int n, int k){
        if(n == 0 && k == 0){
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i = index; i < 9; i++){
            if(n < i + 1)
                break;
            temp.add(i + 1);
            dfs(list, temp, i + 1, n - i - 1, k - 1);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if(n <= 0 || k > 9) return list;
        dfs(list, temp, 0, n, k);
        return list;
    }
}
