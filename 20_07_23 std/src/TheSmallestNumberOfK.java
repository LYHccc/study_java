/*最小的k个数
题目描述
输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TheSmallestNumberOfK {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(k > input.length) return list;
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                return b - a;
            }
        });

        for(int a : input){
            queue.offer(a);
            if(queue.size() > k){
                queue.poll();
            }
        }
        while(!queue.isEmpty()){
            list.add(queue.poll());
        }

        return list;
    }
}
