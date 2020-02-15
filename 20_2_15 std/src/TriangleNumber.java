//给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
import java.util.Arrays;

public class TriangleNumber {
    //方法一：
    public static int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            for(int j = i + 1; j < nums.length - 1; j++){
                for(int k = j + 1; k < nums.length; k++){
                    if(nums[i] + nums[j] > nums[k])
                        count++;
                }
            }
        }
        return count;
    }

    //方法二：
    /*
    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            int k = i + 2;
            for(int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++){
                while(k < nums.length && nums[i] + nums[j] > nums[k])
                    k++;
                count += k - j - 1;
            }
        }
        return count;
    }
    */
    public static void main(String[] args) {
        int[] num = {2, 2, 3 , 4};
        System.out.println(triangleNumber(num));
    }
}
