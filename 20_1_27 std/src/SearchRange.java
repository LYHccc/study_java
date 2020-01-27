//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//你的算法时间复杂度必须是 O(log n) 级别。
//如果数组中不存在目标值，返回 [-1, -1]。

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(target < nums[mid]){
                right = mid - 1;
            }else if(target > nums[mid]){
                left = mid + 1;
            }else{
                index = mid;
                break;
            }
        }
        if(index == -1){
            return new int[]{-1, -1};
        }else{
            int goleft = index;
            int goright = index;
            while(goleft > 0 && nums[goleft - 1] == target){
                goleft--;
            }
            while(goright < nums.length - 1 && nums[goright + 1] == target){
                goright++;
            }
            return new int[]{goleft, goright};
        }
    }
}
