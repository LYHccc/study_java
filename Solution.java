//在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
//给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
//返回可以通过分割得到的平衡字符串的最大数量。
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int balancedStringSplit(String s){
        List<Character> list = new ArrayList<>();
        char[] c = s.toCharArray(); //rlrrllrlrl
        int count = 0;
        for(int i = 0; i < c.length; i++){
            if(list.isEmpty()){
                list.add(c[i]);
            }else{
                if(list.get(list.size() - 1) != c[i]){
                    list.remove(list.size() - 1);
                    if(list.isEmpty()){
                        count++;
                    }
                }else{
                    list.add(c[i]);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.balancedStringSplit("rlrrllrlrl");
        System.out.println(result);
    }
}
