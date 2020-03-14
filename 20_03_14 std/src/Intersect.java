//给定两个数组，编写一个函数来计算它们的交集。
//输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
//我们可以不考虑输出结果的顺序。
import java.util.Arrays;

public class Intersect {
    public static int[] intersect(int[] nums1, int[] nums2) {
        int[] arr = new int[Math.min(nums1.length, nums2.length)];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index = 0;
        int index1 = 0;
        int index2 = 0;
        while(index1 < nums1.length && index2 < nums2.length){
            if(nums1[index1] > nums2[index2]){
                index2++;
            }else if(nums1[index1] > nums2[index2]){
                index1++;
            }else{
                arr[index] = nums1[index1];
                index++;
                index1++;
                index2++;
            }
        }
        int[] a = new int[index];
        a = Arrays.copyOfRange(arr, 0, index);
        return a;
    }
}
