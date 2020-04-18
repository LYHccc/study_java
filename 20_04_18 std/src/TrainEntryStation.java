/*火车进站
给定一个正整数N代表火车数量，0<N<10，接下来输入火车入站的序列，一共N辆火车，每辆火车以数字1-9编号。要求以字典序排序输出火车出站的序列号。

输入描述:
有多组测试用例，每一组第一行输入一个正整数N（0<N<10），第二行包括N个正整数，范围为1到9。

输出描述:
输出以字典序从小到大排序的火车出站序列号，每个编号以空格隔开，每个输出序列换行，具体见sample。

示例1
输入
3
1 2 3
输出
1 2 3
1 3 2
2 1 3
2 3 1
3 2 1
 */
import java.util.*;

public class TrainEntryStation {
    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }

        //用一个栈来模拟火车站的情况
        Stack<Integer> stack = new Stack<>();
        //找出火车的所有出站情况
        trainout(arr, 0, 0, stack, "");
        //对所有情况进行排序
        Collections.sort(list);
        //打印
        for(String s : list){
            System.out.println(s);
        }
    }

    //火车的出站情况
    private static void trainout(int[] arr, int in, int out, Stack<Integer> stack, String s){
        if(out == arr.length){//如果所有火车都已经出站，将结果保留
            list.add(s);
        }

        if(in < arr.length){//如果有火车还没有进站，则进站
            stack.push(arr[in]);//该火车进站
            trainout(arr, in + 1, out, stack, s);//进站后的此时火车可能出站情况
            stack.pop();//恢复现场
        }

        if(!stack.isEmpty()){//如果还有火车没有出站
            int temp = stack.pop();//出站的火车
            trainout(arr, in, out + 1, stack, s + temp + " ");//该火车出站后其余火车可能出站情况
            stack.push(temp);//恢复现场
        }
    }
}
