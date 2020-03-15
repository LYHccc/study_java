//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
import java.util.HashMap;

public class SingleNumber {
    /*
    //方法1：
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int num : nums){
            if(map.get(num) == 1){
                return num;
            }
        }
        return -1;
    }
    */
    //方法二：两个相同的数异或为0，最后剩余单独的一个值
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int num : nums){
            result ^= num;
        }
        return result;
    }
}
