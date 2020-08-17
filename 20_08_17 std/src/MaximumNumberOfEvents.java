/**
 * 最多可以参加的会议数量
 * 给你一个数组events，其中events[i] = [startDayi, endDayi]表示会议i开始于startDayi，束于endDayi。
 * 你可以在满足startDayi<= d <= endDayi中的任意一天d参加会议i。注意一天只能参加一个会议。
 * 请你返回你可以参加的 最大 会议数目。
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumNumberOfEvents {
    public static int maxEvents(int[][] events) {
        //按照开始天数排序
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        //小根堆，存放所有可进行会议的结束日期
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int num = events.length;
        int res = 0, day = 1, index = 0;
        while(index < num || !queue.isEmpty()) {
            //存放开始时间在day的会议的结束日期
            while (index < num && events[index][0] == day) {
                queue.offer(events[index][1]);
                index++;
            }
            //不进行会议出队，即结束时间超过了day
            while (!queue.isEmpty() && queue.peek() < day) {
                queue.poll();
            }
            //如果队列不为空，说明今天可以进行的会议，res++
            if (queue.poll() != null) {
                res++;
            }
            day++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println(maxEvents(arr));
    }
}
