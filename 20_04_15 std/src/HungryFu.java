/*饥饿的小易
题目描述
小易总是感觉饥饿，所以作为章鱼的小易经常出去寻找贝壳吃。最开始小易在一个初始位置x_0。对于小易所处的当前位置x，他只能通过神秘的力量移动到 4 * x + 3或者8 * x + 7。因为使用神秘力量要耗费太多体力，所以它只能使用神秘力量最多100,000次。贝壳总生长在能被1,000,000,007整除的位置(比如：位置0，位置1,000,000,007，位置2,000,000,014等)。小易需要你帮忙计算最少需要使用多少次神秘力量就能吃到贝壳。

输入描述:
输入一个初始位置x_0,范围在1到1,000,000,006

输出描述:
输出小易最少需要使用神秘力量的次数，如果使用次数使用完还没找到贝壳，则输出-1
 */
import java.util.Scanner;

public class HungryFu {
    /*基本思路
    x = 2x + 1;
    4 * x + 3 = 2 * (2x + 1) + 1;       //执行两次x = 2x + 1
    8 * x + 7 = 2 * (2(2x + 1) + 1) + 1;//执行三次 x = 2x + 1
    统计执行多少次x = 2x + 1， 可以使得得到的x % 1000000007 = 0;
    再将次数分解成若干个3和2的组合，找到3和2的最小组合次数，次数小于100000
     */
    private static int find(int n){
        int count = 0;
        if(n == 0){
            return 0;
        }
        for(int i = 0; i < 300000; i++){
            n = ((n * 2) + 1) % 1000000007;
            count++;
            if(n == 0) break;
        }

        if(count == 1) return 0;
        if(count == 2) return 1;

        if(count % 3 == 0){
            if(count / 3 < 100000){
                return count / 3;
            }
        }else{
            if(count / 3 + 1 < 100000){
                return count / 3 + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(find(num));
    }
}
