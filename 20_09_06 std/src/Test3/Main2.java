/**
 * 通知传递
 * 公司共有n个人，编号0到n-1 ，m个部门，每个人可能属于多个部门，也有可能不属于任何部门
 * 给编号为0的人通知一个消息，与0处于同一个部门的所有员工都可以收到这个消息
 * 同时这些员工可将消息传递给他所在其他部门的所有人员，返回最后可以有多少员工知道这个消息
 * 输入描述：
 * 第一行两个整数n和m，代表总人数和团队数量
 * 之后m行，每行第一个数字x代表该部门总人数，之后x个数字代表该部门的员工编号
 */
package Test3;

import java.util.*;

public class Main2 {
    private static Set<Integer> res;//保存所有知道消息的人

    private static void bfs(List<List<Integer>> lists){
        Set<Integer> visited = new HashSet<>();//保存遍历过的小组下标
        Queue<Integer> queue = new LinkedList<>();//保存遍历过程中的小组下标
        for(int i = 0; i < lists.size(); i++){
            if(lists.get(i).contains(0)){
                queue.offer(i);
                visited.add(i);
                for(int person : lists.get(i)){
                    res.add(person);
                }
            }
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int group = queue.poll();
                for(int a : lists.get(group)){
                    for(int j = 0; j < lists.size(); j++){
                        if(!visited.contains(j) && lists.get(j).contains(a)){
                            queue.offer(j);
                            visited.add(j);
                            for(int person : lists.get(j)){
                                res.add(person);
                            }
                        }
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//总人数
        int m = scanner.nextInt();//团队数量
        List<List<Integer>> lists = new ArrayList<>();
        for(int i = 0; i < m; i++){
            int x = scanner.nextInt();//i团队人数
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < x; j++){
                list.add(scanner.nextInt());
            }
            lists.add(list);
        }
        res = new HashSet<>();
        bfs(lists);
        System.out.println(res.size());
    }
}
