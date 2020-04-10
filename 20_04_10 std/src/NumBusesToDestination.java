/*公交路线
我们有一系列公交路线。每一条路线 routes[i] 上都有一辆公交车在上面循环行驶。
例如，有一条路线 routes[0] = [1, 5, 7]，表示第一辆 (下标为0) 公交车会一直按照 1->5->7->1->5->7->1->... 的车站路线行驶。

假设我们从 S 车站开始（初始时不在公交车上），要去往 T 站。 期间仅可乘坐公交车，
求出最少乘坐的公交车数量。返回 -1 表示不可能到达终点车站。

示例:
输入:
routes = [[1, 2, 7], [3, 6, 7]]
S = 1
T = 6
输出: 2
解释:
最优策略是先乘坐第一辆公交车到达车站 7, 然后换乘第二辆公交车到车站 6。
 */
import java.util.*;

public class NumBusesToDestination {
    public static int numBusesToDestination(int[][] routes, int S, int T) {
        if(S == T) return 0;

        //map中key值表示每一个车站，value表示会经过这个车站的所有车(用一个list存储)
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < routes.length; i++){
            for(int j = 0; j < routes[i].length; j++){
                //存储key - value映射内容
                //1.给每个key对应的value开一个list空间，开过的不用再开
                map.putIfAbsent(routes[i][j], new LinkedList<Integer>());
                //2.将经过key车站的车，存入对应的value中
                map.get(routes[i][j]).add(i);
            }
        }

        //set用来存储已经遍历过的车
        HashSet<Integer> set = new HashSet<>();
        //队列中存放要遍历的车站
        Queue<Integer> queue = new LinkedList<>();
        //先将开始的车站S存到queue中
        queue.offer(S);
        //用count用来记录要乘坐的公交车数量
        int count = 1;
        //基本思路是这样的：
        //1.先从经过车站S的车中找，看是否可以到达终点T(在这个过程中将遍历到车站放到queue中，下边会解释)，如果可以返回count，
        //2. 如果不可以，count + 1，并继续从刚刚存入队列中的车站station开始，从经过station的车中找看是否可以到达T
        //因为此时队列中存储的都是上一轮车可以经过的车站(也就是可以从S开始的车从station站换乘到其他车上的)，接着就可以从其他车经过的车站去找是否可以到达T
        //3.继续列斯这个过程，直到找到 T 或者全部找完都到不了T
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                //从station开始
                int station = queue.poll();
                //经过这个车站的车
                List<Integer> bus_list = map.get(station);
                //遍历这些车
                for(int bus : bus_list){
                    //如果还没有遍历过
                    if(set.add(bus)){
                        //从这些车经过的车站里判断有没有T
                        for(int j = 0; j < routes[bus].length; j++){
                            if(routes[bus][j] == T){
                                return count;
                            }else{
                                queue.offer(routes[bus][j]);
                            }
                        }
                    }
                }
            }
            //这一轮的车没有经过T的
            count++;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 7},{3, 6, 7}};
        System.out.println(numBusesToDestination(arr, 1, 6));
    }
}
