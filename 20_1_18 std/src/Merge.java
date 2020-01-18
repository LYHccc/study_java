//给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
//说明:初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
//你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。

import java.util.Arrays;

public class Merge {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n - 1;
        int len1 = m - 1;
        int len2 = n - 1;
        while(len1 >= 0 && len2 >= 0){
            if(nums2[len2] >= nums1[len1]){
                nums1[len--] = nums2[len2--];
            }else{
                nums1[len--] = nums1[len1--];
            }
        }
        if(len1 <= 0){
            for(int i = 0; i <= len2; i++){
                nums1[i] = nums2[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {0};
        int[] nums2 = {1};
        merge(nums1, 0, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }
}
