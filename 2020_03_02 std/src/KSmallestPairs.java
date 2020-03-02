//给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。
//定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。
//找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class KSmallestPairs {
    private static int twoSum(int[] arr){
        return arr[0] + arr[1];
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> list = new LinkedList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                return twoSum(arr2) - twoSum(arr1);
            }
        });

        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                int[] num = new int[]{nums1[i], nums2[j]};
                queue.offer(num);
                if(queue.size() > k){
                    queue.poll();
                }
            }
        }

        while(!queue.isEmpty()){
            List<Integer> tList = new LinkedList<>();
            int[] num = queue.poll();
            tList.add(num[0]);
            tList.add(num[1]);
            list.add(tList);
        }
        return list;
    }
}
