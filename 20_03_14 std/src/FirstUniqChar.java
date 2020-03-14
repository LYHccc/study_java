//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
import java.util.HashMap;

public class FirstUniqChar {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.get(c) == 1){
                return i;
            }
        }
        return -1;
    }
}
