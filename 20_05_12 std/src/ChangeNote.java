/*找零钱
如果你是哈利·波特迷，你会知道魔法世界有它自己的货币系统 —— 就如海格告诉哈利的：
“十七个银西可(Sickle)兑一个加隆(Galleon)，二十九个纳特(Knut)兑一个西可，很容易。”
现在，给定哈利应付的价钱P和他实付的钱A，你的任务是写一个程序来计算他应该被找的零钱。

输入描述:
输入在1行中分别给出P和A，格式为“Galleon.Sickle.Knut”，其间用1个空格分隔。
这里Galleon是[0, 107]]区间内的整数，Sickle是[0, 17)区间内的整数，Knut是[0, 29)区间内的整数。

输出描述:
在一行中用与输入同样的格式输出哈利应该被找的零钱。如果他没带够钱，那么输出的应该是负数。

示例1
输入
10.16.27 14.1.28
输出
3.2.1
 */
import java.util.Scanner;

public class ChangeNote {
    /*
    //方法一：铁憨憨写法，千万别这样写了
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();
        int borrow = 0;

        String[] cost = s1.split("\\.");
        String[] pay = s2.split("\\.");
        int[] costArr = new int[3];
        int[] payArr = new int[3];
        for(int i = 0; i < cost.length; i++){
            costArr[i] = Integer.parseInt(cost[i]);
        }
        for(int i = 0; i < pay.length; i++){
            payArr[i] = Integer.parseInt(pay[i]);
        }

        boolean flag = false;
        if(payArr[0] > costArr[0]){
            flag = true;
        }else if(payArr[0] == costArr[0]){
            if(payArr[1] > costArr[1]){
                flag = true;
            }else if(payArr[1] == costArr[1]){
                if(payArr[2] >= costArr[2]){
                    flag = true;
                }
            }
        }

        if(flag) {
            StringBuilder str = new StringBuilder();
            if (payArr[2] >= costArr[2]) {
                str.insert(0, payArr[2] - costArr[2]).insert(0, ".");
            } else {
                str.insert(0,(payArr[2] + 29) - costArr[2]).insert(0, ".");
                borrow = 1;
            }

            if ((payArr[1] - borrow) >= costArr[1]) {
                str.insert(0, (payArr[1] - borrow) - costArr[1]).insert(0, ".");
                borrow = 0;
            } else {
                str.insert(0, (payArr[1] - borrow + 17) - costArr[1]).insert(0, ".");
                borrow = 1;
            }

            str.insert(0,(payArr[0] - borrow) - costArr[0]);
            System.out.println(str.toString());
        }else{
            StringBuilder str = new StringBuilder();
            if (costArr[2] >= payArr[2]) {
                str.insert(0, costArr[2] - payArr[2]).insert(0, ".");
            } else {
                str.insert(0,(costArr[2] + 29) - payArr[2]).insert(0, ".");
                borrow = 1;
            }

            if ((costArr[1] - borrow) >= payArr[1]) {
                str.insert(0, (costArr[1] - borrow) - payArr[1]).insert(0, ".");
                borrow = 0;
            } else {
                str.insert(0, (costArr[1] - borrow + 17) - payArr[1]).insert(0, ".");
                borrow = 1;
            }

            str.insert(0, (costArr[0] - borrow) - payArr[0]).insert(0, "-");
            System.out.println(str.toString());
        }
    }
    */

    //方法二：将输入的货币转化为类似整数的个、十、百位的形式
    //不同的是，个位满29进1，十位满17进1
    private static final int[] unit = {17 * 29, 29, 1};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();
        String[] cost = s1.split("\\.");
        String[] pay = s2.split("\\.");
        int[] costArr = new int[3];
        int[] payArr = new int[3];

        for(int i = 0; i < cost.length; i++){
            costArr[i] = Integer.parseInt(cost[i]);
        }
        for(int i = 0; i < pay.length; i++){
            payArr[i] = Integer.parseInt(pay[i]);
        }

        int costNum = costArr[0] * unit[0] + costArr[1] * unit[1] + costArr[2] * unit[2];
        int payNum = payArr[0] * unit[0] + payArr[1] * unit[1] + payArr[2] * unit[2];

        int temp = payNum - costNum;
        if(payNum < costNum){
            System.out.print("-");
            temp = -temp;
        }

        System.out.println(temp / unit[0] + "." + (temp % unit[0]) / unit[1] + "." + (temp % unit[1]) / unit[2]);
    }
}
