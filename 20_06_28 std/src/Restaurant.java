/*餐馆
题目描述
某餐馆有n张桌子，每张桌子有一个参数：a 可容纳的最大人数；
有m批客人，每批客人有两个参数:b人数，c预计消费金额。
在不允许拼桌的情况下，请实现一个算法选择其中一部分客人，使得总预计消费金额最大

输入描述:
输入包括m+2行。 第一行两个整数n(1 <= n <= 50000),m(1 <= m <= 50000) 第二行为n个参数a,即每个桌子可容纳的最大人数,以空格分隔,范围均在32位int范围内。 接下来m行，每行两个参数b,c。分别表示第i批客人的人数和预计消费金额,以空格分隔,范围均在32位int范围内。

9输出描述:
输出一个整数,表示最大的总预计消费金额
 */
import java.util.*;

class Customer{
    int num;
    int cost;

    public Customer(int num, int cost){
        this.num = num;
        this.cost = cost;
    }
}

public class Restaurant{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] table = new int[n];
            for (int i = 0; i < n; i++) {
                table[i] = scanner.nextInt();
            }
            Arrays.sort(table);//桌子大小升序排列

            //优先级队列大根堆，保存客人信息，消费金额多的客人在前
            PriorityQueue<Customer> queue = new PriorityQueue<>(new Comparator<Customer>() {
                @Override
                public int compare(Customer o1, Customer o2) {
                    return o2.cost - o1.cost;
                }
            });
            //只要客人人数最大桌子能够容纳，就让这一批客人入队
            for (int i = 0; i < m; i++) {
                int b = scanner.nextInt();
                int c = scanner.nextInt();
                if (b <= table[n - 1]) {
                    queue.offer(new Customer(b, c));
                }
            }

            boolean[] visit = new boolean[n];
            long sum = 0;//预计消费总金额
            int count = 0;//记录用过的桌子数量
            while (!queue.isEmpty()) {
                Customer customer = queue.poll();
                //从小桌子开始遍历
                for (int i = 0; i < n; i++) {
                    //如果桌子没有被占用，并且可以容纳下这一批顾客
                    if (customer.num <= table[i] && !visit[i]) {
                        sum += customer.cost;
                        count++;
                        visit[i] = true;
                        break;
                    }
                }
                if(count == n) break;
            }

            System.out.println(sum);
        }
    }
}