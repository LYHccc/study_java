//给定一个二进制数组, 找到含有相同数量的 0 和 1 的最长连续子数组（的长度）。
import java.util.HashMap;

public class FindMaxLength {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0, max = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                count--;
            }else{
                count++;
            }
            if(count == 0){//count等于零说明从开始的位置到此时的位置0和1 的个数是相等的
                max = Math.max(max, i + 1);
            }else if(map.containsKey(count)){//count第一次出现的位置后到现在的位置之间0和1的个数是相等的
                max = Math.max(max, i - map.get(count));
            }else{//保存count第一次出现的位置
                map.put(count, i);
            }
        }
        return max;
    }
}
