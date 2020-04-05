/*n个数里出现次数大于等于n/2的数
题目描述:
输入n个整数，输出出现次数大于等于数组长度一半的数。
输入描述:
每个测试输入包含 n个空格分割的n个整数，n不超过100，其中有一个整数出现次数大于等于n/2。
输出描述:
输出出现次数大于等于n/2的数。
 */
import java.util.HashMap;
import java.util.Scanner;

public class FindNumber {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        while(scanner.hasNextInt()){
            int num = scanner.nextInt();
            count++;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int a : map.keySet()){
            if(map.get(a) >= count / 2){
                System.out.println(a);
                break;
            }
        }
    }
}
