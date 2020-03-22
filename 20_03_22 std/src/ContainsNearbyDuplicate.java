//给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
import java.util.HashMap;

public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int a = nums[i];
            if(map.containsKey(a)){
                if(i - map.get(a) <= k){
                    return true;
                }else{
                    map.put(a, i);
                }
            }else{
                map.put(a, i);
            }
        }
        return false;
    }
}
