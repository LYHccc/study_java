//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//说明：解集不能包含重复的子集。

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subset = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        subset.add(list);
        for(int i = 0; i < nums.length; i++){
            int size = subset.size();
            for(int j = 0; j < size; j++){
                List<Integer> list1 = subset.get(j);
                List<Integer> temp = new ArrayList<>(list1);
                temp.add(nums[i]);
                subset.add(temp);
            }
        }
        return subset;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }
}
