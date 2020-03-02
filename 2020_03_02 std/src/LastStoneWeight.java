//有一堆石头，每块石头的重量都是正整数。
//每一回合，从中选出两块最重的石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
//如果 x == y，那么两块石头都会被完全粉碎；
//如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
//最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1) return stones[0];
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return b - a;
            }
        });

        for(int i = 0; i < stones.length; i++){
            queue.offer(stones[i]);
        }

        while(!queue.isEmpty()){
            int n1 = queue.poll();
            int n2 = queue.poll();
            int num = Math.abs(n1 - n2);
            queue.offer(num);
            if(queue.size() == 1){
                return num;
            }
        }
        return 0;
    }
}
