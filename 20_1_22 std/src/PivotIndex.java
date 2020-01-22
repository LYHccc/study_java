//给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
//我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
//如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。

public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int leftnum = 0;
        int rightnum = 0;
        for(int i = 0; i < nums.length; i++){
            rightnum += nums[i];
        }
        for(int i = 0; i < nums.length; i++){
            rightnum -= nums[i];
            if(i != 0){
                leftnum += nums[i - 1];
            }
            if(rightnum == leftnum){
                return i;
            }
        }
        return -1;
    }
}
