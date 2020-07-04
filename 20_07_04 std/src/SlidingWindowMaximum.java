import java.util.ArrayList;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    /*
    //方法一：暴力
    public static ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> list = new ArrayList<>();
        if(size == 0){
            return list;
        }
        int len = num.length;
        int left = 0;
        while(left + size - 1 < len){
            int max = num[left];
            for(int i = left + 1; i < left + size; i++){
                max = Math.max(max, num[i]);
            }
            list.add(max);
            left++;
        }
        return list;
    }
    */

    //方法二：维持一个双端队列，队列中存放每一个窗口的可能最大值
    public static ArrayList<Integer> maxInWindows(int [] num, int size){
        int len = num.length;
        ArrayList<Integer> res = new ArrayList<>();
        if(size <= 0 || len < size) return res;
        LinkedList<Integer> queue = new LinkedList<>();

        for(int i = 0; i < len; i++){
            //如果队尾元素小于当前元素，删除队尾元素，因为它已经不可能是后边窗口的最大值了
            while(!queue.isEmpty() && num[queue.peekLast()] < num[i]){
                queue.pollLast();
            }
            queue.addLast(i);
            if(queue.peekFirst() == i - size)
                queue.pollFirst();
            if(i >= size - 1)
                res.add(num[queue.peekFirst()]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,2,6,2,5,1};
        System.out.println(maxInWindows(arr, 3));
    }
}
