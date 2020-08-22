/**
 *组合总和 II
 * 给定一个数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * candidates中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 *
 * 与组合总数不同的就是每个数字不能被重复选取
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumⅡ {
    private void dfs(List<List<Integer>> list, List<Integer> temp, int[] arr, int target, int index){
        if(target == 0){
            list.add(new ArrayList(temp));
            return;
        }
        for(int i = index; i < arr.length; i++){
            //数组单调递增，此处大于目标值，后边的肯定都大于
            if(target < arr[i])
                break;
            //排序数组相同元素一定挨着
            //不能出现重复数组，此处i > index说明执行了i++，也就是说肯定是递归过后，remove后边执行的
            //如果此次加入的数字和上个相等，那就没必要加入这个，因为这个相同的已经递归过了
            if(i > index && arr[i] == arr[i - 1])
                continue;
            temp.add(arr[i]);
            dfs(list, temp, arr, target - arr[i], i + 1);
            temp.remove(temp.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        //排序
        Arrays.sort(candidates);
        dfs(list, temp, candidates, target, 0);
        return list;
    }
}
