//给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一样，优先选择数值较小的那个数。

import java.util.LinkedList;
import java.util.List;

public class FindClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int size = arr.length;
        int left = 0;
        int right = size - 1;
        int removeNum = size - k;
        while(removeNum > 0){
            if(Math.abs(arr[right] - x) >= Math.abs(arr[left] - x)){
                right--;
            }else{
                left++;
            }
            removeNum--;
        }
        List<Integer> list = new LinkedList<>();
        for(int i = left; i <= right; i++){
            list.add(arr[i]);
        }
        return list;
    }
}
