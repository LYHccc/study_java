/*第一个只出现一次的字符
题目描述
在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 */
import java.util.HashMap;

public class FirstCharacterAppearOnce {
    //方法一：用HashMap存储
    public int FirstNotRepeatingChar(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i < str.length(); i++){
            if(map.get(str.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

    //方法二：用数组存储
    /*
    public int FirstNotRepeatingChar(String str) {
        int[] arr = new int[58];
        for(int i = 0; i < str.length(); i++){
            arr[str.charAt(i) - 'A']++;
        }
        for(int i = 0; i < str.length(); i++){
            if(arr[str.charAt(i) - 'A'] == 1)
                return i;
        }
        return -1;
    }
    */
}
