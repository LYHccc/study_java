/*马戏团
题目描述
搜狐员工小王最近利用假期在外地旅游，在某个小镇碰到一个马戏团表演，
精彩的表演结束后发现团长正和大伙在帐篷前激烈讨论，小王打听了下了解到，
马戏团正打算出一个新节目“最高罗汉塔”，即马戏团员叠罗汉表演。
考虑到安全因素，要求叠罗汉过程中，站在某个人肩上的人应该既比自己矮又比自己瘦，或相等。
团长想要本次节目中的罗汉塔叠的最高，由于人数众多，正在头疼如何安排人员的问题。
小王觉得这个问题很简单，于是统计了参与最高罗汉塔表演的所有团员的身高体重，并且很快找到叠最高罗汉塔的人员序列。
现在你手上也拿到了这样一份身高体重表，请找出可以叠出的最高罗汉塔的高度，
这份表中马戏团员依次编号为1到N。

输入描述:
首先一个正整数N，表示人员个数。
之后N行，每行三个数，分别对应马戏团员编号，体重和身高。

输出描述:
正整数m，表示罗汉塔的高度。
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class People{
    int high;
    int weight;

    public People(int high, int weight){
        this.high = high;
        this.weight = weight;
    }
}

public class Circus {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            People[] people = new People[n];
            for (int i = 1; i <= n; i++) {
                int number = scanner.nextInt();
                int weight = scanner.nextInt();
                int high = scanner.nextInt();
                people[number - 1] = new People(high, weight);
            }

            Arrays.sort(people, new Comparator<People>() {
                @Override
                public int compare(People o1, People o2) {
                    int temp = o1.high - o2.high;
                    if (temp != 0) {
                        return temp;
                    } else {
                        return o1.weight - o2.weight;
                    }
                }
            });

            int[] dp = new int[n];
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                dp[i] = 1;
                for (int j = i - 1; j >= 0; j--) {
                    if ((people[i].high == people[j].high && people[i].weight >= people[j].weight)
                            || (people[i].weight > people[j].weight)) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                max = Math.max(max, dp[i]);
            }

            System.out.println(max);
        }
    }
}
