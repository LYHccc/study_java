/**
 * 无重叠区间
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * 注意:
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 */

import java.util.Arrays;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        //按照区间起点从小到大排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int res = 0;
        int cur = 0;
        for(int i = 1; i < intervals.length; i++){
            if(intervals[cur][1] <= intervals[i][0]){
                cur = i;
            }else{
                if(intervals[cur][1] >= intervals[i][1]){
                    cur = i;
                }
                res++;
            }
        }

        return res;
    }
}
