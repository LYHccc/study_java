//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
import java.util.HashMap;
import java.util.HashSet;

public class LengthOfLongestSubstring {
    /*
    方法一：
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        while(left < s.length() && right < s.length()){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right++));
                max = Math.max(max, right - left);
            }else{
                set.remove(s.charAt(left++));
            }
        }
        return max;
    }
    */

    //方法二：
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        while(left < s.length() && right < s.length()){
            if(map.containsKey(s.charAt(right))){
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            map.put(s.charAt(right), right);
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
