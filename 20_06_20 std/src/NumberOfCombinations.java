/*组合总数
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的数字可以无限制重复被选取。
说明：
所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 
 */
import java.util.LinkedList;
import java.util.List;

public class NumberOfCombinations {
    private static void dfs(int[] candidates, int target, int curSum, int index,
                     List<List<Integer>> list, List<Integer> temp){
        if(curSum == target){
            List<Integer> l = new LinkedList<>();
            for(int a : temp){
                l.add(a);
            }
            list.add(l);
            return;
        }
        if(curSum > target) return;
        for(int i = index; i < candidates.length; i++){
            temp.add(candidates[i]);
            dfs(candidates, target, curSum + candidates[i], i, list, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new LinkedList<>();
        List<Integer> temp = new LinkedList<>();
        dfs(candidates, target, 0, 0, list, temp);
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(arr, target));
    }
}
