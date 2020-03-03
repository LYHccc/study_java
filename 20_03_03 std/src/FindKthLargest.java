//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
import java.util.Arrays;
import java.util.PriorityQueue;

public class FindKthLargest {
    /*
    //方法一：排序找到倒数第k个
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
    */

    //方法二：建立小根堆，存储k个元素，返回堆顶元素
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int value : nums){
            queue.add(value);
            if(queue.size() > k){
                queue.poll();
            }
        }
        return queue.poll();
    }
}
