/*乒乓球筐
nowcoder有两盒（A、B）乒乓球，有红双喜的、有亚力亚的……现在他需要判别A盒是否包含了B盒中所有的种类
，并且每种球的数量不少于B盒中的数量，该怎么办呢？

输入描述:
输入有多组数据。
每组数据包含两个字符串A、B，代表A盒与B盒中的乒乓球，每个乒乓球用一个大写字母表示，
即相同类型的乒乓球为相同的大写字母。字符串长度不大于10000。

输出描述:
每一组输入对应一行输出：如果B盒中所有球的类型在A中都有，并且每种球的数量都不大于A，则输出“Yes”；否则输出“No”。
 */
import java.util.HashMap;
import java.util.Scanner;

public class PingPongBox {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            boolean flag = true;
            String s1 = scanner.next();
            String s2 = scanner.next();
            HashMap<Character, Integer> a = new HashMap<>();
            HashMap<Character, Integer> b = new HashMap<>();

            for(char c : s1.toCharArray()){
                a.put(c, a.getOrDefault(c, 0) + 1);
            }
            for(char c : s2.toCharArray()){
                b.put(c, b.getOrDefault(c, 0) + 1);
            }

            for(char c : b.keySet()){
                if(!a.containsKey(c)){
                    flag = false;
                }else{
                    if(a.get(c) < b.get(c)){
                        flag = false;
                    }
                }
            }

            if(flag){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
}
