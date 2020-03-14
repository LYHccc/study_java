//给定两个数组，编写一个函数来计算它们的交集。
//输出结果中的每个元素一定是唯一的。
//我们可以不考虑输出结果的顺序。
import java.util.Arrays;
import java.util.HashSet;

public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for(int a : nums1){
            set1.add(a);
        }
        for(int a : nums2){
            set2.add(a);
        }
        int[] arr = new int[Math.min(nums1.length, nums2.length)];
        int index = 0;
        for(int a : set1){
            if(set2.contains(a)){
                arr[index++] = a;
            }
        }
        return Arrays.copyOfRange(arr, 0, index);
    }
}
