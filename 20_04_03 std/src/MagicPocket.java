/*神奇的口袋
题目描述:
有一个神奇的口袋，总的容积是40，用这个口袋可以变出一些物品，这些物品的总体积必须是40。John现在有n个想要得到的物品，每个物品的体积分别是a1，a2……an。John可以从这些物品中选择一些，如果选出的物体的总体积是40，那么利用这个神奇的口袋，John就可以得到这些物品。现在的问题是，John有多少种不同的选择物品的方式。
输入描述:
输入的第一行是正整数n (1 <= n <= 20)，表示不同的物品的数目。接下来的n行，每行有一个1到40之间的正整数，分别给出a1，a2……an的值。
输出描述:
输出不同的选择物品的方式的数目。
 */


/*
//方法一：铁憨憨暴力法，找出所有子集，判断满足条件的
//时间复杂度过大，超时
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MagicPocket {
    private static List<List<Integer>> allResult(int[] arr){
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list.add(list1);

        for(int i = 0; i < arr.length; i++){
            int size = list.size();
            for(int j = 0; j < size; j++){
                List<Integer> list2 = list.get(j);
                List<Integer> temp = new ArrayList<>(list2);
                temp.add(arr[i]);
                list.add(temp);
            }
        }

        return list;
    }

    private static int count(List<List<Integer>> list){
        int count = 0;
        for(int i = 0; i < list.size(); i++){
            int num = 0;
            for(int j = 0; j < list.get(i).size(); j++){
                num += list.get(i).get(j);
            }
            if(num == 40){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println(count(allResult(arr)));
    }
}
*/

//方法二：递归
import java.util.Scanner;

public class MagicPocket{
    static int[] arr = new int[21];
    //表示从第k个物品开始向前，此时口袋容量为sum，满足条件的选择方式共有多少种
    private static int count(int k, int sum){
        //如果容量刚好等于零，说明满足一次
        if(sum == 0){
            return 1;
        }
        //如果第一个物品找过了(即到了0位置)，说明这次无法满足条件
        if(k <= 0){
            return 0;
        }
        //从第k个物品开始向前，此时口袋容量为sum，满足条件的所有方式，可以分为两种情况
        //1.将第k个物品装进口袋，计算从k - 1个物品开始共有多少种满足条件的方式
        //2.不将第k个装进口袋，计算从k - 1个物品开始共有多少种满足条件的方式
        //将二者相加
        return count(k - 1, sum - arr[k]) + count(k - 1, sum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 1; i <= n; i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println(count(n, 40));
    }
}

