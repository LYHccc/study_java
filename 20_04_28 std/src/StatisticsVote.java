/*记票统计
输入描述:
输入候选人的人数，第二行输入候选人的名字，第三行输入投票人的人数，第四行输入投票。

输出描述:
每行输出候选人的名字和得票数量。
 */
import java.util.*;

public class StatisticsVote {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int n = scanner.nextInt();
            HashMap<String, Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < n; i++) {
                String s = scanner.next();
                map.put(s, 0);
            }

            int invalid = 0;
            int vote = scanner.nextInt();
            String[] arr = new String[vote];
            for (int i = 0; i < vote; i++) {
                arr[i] = scanner.next();
            }
            for (String s : arr) {
                if (map.containsKey(s)) {
                    map.put(s, map.get(s) + 1);
                } else {
                    invalid++;
                }
            }

            for (String s : map.keySet()) {
                System.out.println(s + " : " + map.get(s));
            }
            System.out.println("Invalid" + " : " + invalid);
        }
    }
}
