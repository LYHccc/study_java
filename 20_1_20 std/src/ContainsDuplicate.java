//给定一个整数数组，判断是否存在重复元素。
//如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。

import java.util.Arrays;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        //排序
        Arrays.sort(nums);
        //排序后判断数组中相邻位置元素有没有相等的，如果有说明存在重复元素
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i + 1]){
                return true;
            }
        }
        return false;
    }
}
