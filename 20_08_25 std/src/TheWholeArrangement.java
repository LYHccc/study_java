/**
 * 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 */
import java.util.ArrayList;
import java.util.List;

public class TheWholeArrangement {
    private static boolean[] flag;
    private void dfs(List<List<Integer>> list, List<Integer> temp, int[] nums){
        if(temp.size() == nums.length){
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(flag[i]) continue;
            flag[i] = true;
            temp.add(nums[i]);
            dfs(list, temp, nums);
            temp.remove(temp.size() - 1);
            flag[i] = false;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if(nums.length == 0) return list;
        flag = new boolean[nums.length];
        dfs(list, temp, nums);
        return list;
    }
}
