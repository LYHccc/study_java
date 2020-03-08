//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
//注意:
//不能使用代码库中的排序函数来解决这道题。

public class SortColors {
    private void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            if(left < right && nums[right] != 0){
                right--;
            }
            if(left < right && nums[left] == 0){
                left++;
            }
            swap(nums, left, right);
        }
        if(nums[left] == 0){
            left++;
        }
        right = nums.length - 1;
        while(left < right){
            if(left < right && nums[right] != 1){
                right--;
            }
            if(left < right && nums[left] == 1){
                left++;
            }
            swap(nums, left, right);
        }
    }
}
