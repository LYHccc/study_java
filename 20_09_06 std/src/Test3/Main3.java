/**
 * 字符串次数
 * 给定多个字符串找到出现次数前k大和前k小的字符串，出现字数相同的字符串按照字典序升序排列输出
 * 输入描述：
 * 第一行两个整数n和k，表示字符串数量和需要找到的前k大和k小的数量
 * 之后n行输入n个字符串
 */
package Test3;

import java.util.*;

public class Main3 {
    private static Map<String, Integer> map;//记录字符串出现次数

    private static void save(String[] arr){
        for(String s : arr){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
    }

    private static void print(Map<String, Integer> map, int k){
        List<Map.Entry<String, Integer>> bigList = new ArrayList();
        List<Map.Entry<String, Integer>> smallList = new ArrayList();
        for(Map.Entry entry : map.entrySet()){
            bigList.add(entry);
            smallList.add(entry);
        }
        Collections.sort(bigList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue() != o2.getValue()){
                    return o2.getValue() - o1.getValue();
                }else{
                    return o1.getKey().compareTo(o2.getKey());
                }
            }
        });
        Collections.sort(smallList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue() != o2.getValue()){
                    return o1.getValue() - o2.getValue();
                }else{
                    return o1.getKey().compareTo(o2.getKey());
                }
            }
        });
        int count1 = 0;
        for(Map.Entry entry : bigList){
            System.out.println(entry.getKey() + " " + entry.getValue());
            count1++;
            if(count1 == k)
                break;
        }
        int count2 = 0;
        for(Map.Entry entry : smallList){
            System.out.println(entry.getKey() + " " + entry.getValue());
            count2++;
            if(count2 == k)
                break;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//字符串数
        int k = scanner.nextInt();//需要找到的k个字符串
        String[] arr = new String[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.next();
        }
        map = new HashMap<>();
        save(arr);
        print(map, k);
    }
}
