/**
 * 组合总数
 * 给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    private void dfs(List<List<Integer>> list, List<Integer> temp, int[] arr, int target, int index){
        if(target == 0){
            list.add(new ArrayList(temp));
            return;
        }
        for(int i = index; i < arr.length; i++){
            if(target < arr[i])
                break;
            temp.add(arr[i]);
            dfs(list, temp, arr, target - arr[i], i);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(list, temp, candidates, target, 0);
        return list;
    }
}
