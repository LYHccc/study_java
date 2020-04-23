/*买珠子
小红想买些珠子做一串自己喜欢的珠串。卖珠子的摊主有很多串五颜六色的珠串，但是不肯把任何一串拆散了卖。
于是小红要你帮忙判断一下，某串珠子里是否包含了全部自己想要的珠子？
如果是，那么告诉她有多少多余的珠子；如果不是，那么告诉她缺了多少珠子。

为方便起见，我们用[0-9]、[a-z]、[A-Z]范围内的字符来表示颜色。例如，YrR8RrY是小红想做的珠串；
那么ppRYYGrrYBR2258可以买，因为包含了全部她想要的珠子，还多了8颗不需要的珠子；
ppRYYGrrYB225不能买，因为没有黑色珠子，并且少了一颗红色的珠子。

输入描述:
每个输入包含1个测试用例。每个测试用例分别在2行中先后给出摊主的珠串和小红想做的珠串，两串都不超过1000个珠子。

输出描述:
如果可以买，则在一行中输出“Yes”以及有多少多余的珠子；如果不可以买，则在一行中输出“No”以及缺了多少珠子。其间以1个空格分隔。
 */
import java.util.HashMap;
import java.util.Scanner;

public class BuyBeads {
    private static HashMap<Character, Integer> com = new HashMap<>();
    private static HashMap<Character, Integer> buy = new HashMap<>();
    private static int more = 0;
    private static int less = 0;

    private static void init(String s1, String s2){
        for(char c : s1.toCharArray()){
            com.put(c, com.getOrDefault(c, 0) + 1);
        }
        for(char c : s2.toCharArray()){
            buy.put(c, buy.getOrDefault(c, 0) + 1);
        }
    }

    private static boolean isBuy(){
        for(char c : buy.keySet()){
            if(com.containsKey(c)){
                if(com.get(c) < buy.get(c)){
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }

    private static void printCount(){
        if(isBuy()){
            for(char c : com.keySet()){
                if(buy.containsKey(c)){
                    more += com.get(c) - buy.get(c);
                }else{
                    more += com.get(c);
                }
            }
            System.out.println("Yes " + more);
        }else{
            for(char c : buy.keySet()){
                if(com.containsKey(c)){
                    if(com.get(c) < buy.get(c)){
                        less += buy.get(c) - com.get(c);
                    }
                }else{
                    less += buy.get(c);
                }
            }
            System.out.println("No " + less);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String com = scanner.nextLine();
            String buy = scanner.nextLine();
            init(com, buy);
            printCount();
        }
    }
}
