/*
给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。题目保证至少有一个词不在禁用列表中，而且答案唯一。
禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。
*/
import java.util.HashMap;
import java.util.HashSet;

public class MostCommonWord {
    /*
    //方法一：
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> set = new HashSet<>();
        for(String s : banned){
            set.add(s);
        }
        HashMap<String, Integer> map = new HashMap<>();
        String s1 = paragraph.toLowerCase();
        String[] arr = s1.split("[\\s|!|?|\\'|,|;|.]");
        int max = 0;
        String res = "";
        for(String s : arr){
            if(s.equals(""))
                continue;
            if(!set.contains(s)){
                map.put(s, map.getOrDefault(s, 0) + 1);
                if(map.get(s) > max){
                    res = s;
                    max = map.get(s);
                }
            }
        }
        return res;
    }
    */

    //方法二：
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> set = new HashSet<>();
        for(String s : banned){
            set.add(s);
        }
        HashMap<String, Integer> map = new HashMap<>();
        int max = 0;
        String res = "";
        char[] arr = paragraph.toCharArray();
        int len = arr.length;
        int left = 0, right = 0;
        while(left < len){
            if(Character.isLetter(arr[left])){
                right = left;
                while(right < len && Character.isLetter(arr[right])){
                    right++;
                }
                String temp = paragraph.substring(left, right).toLowerCase();
                if(!set.contains(temp)){
                    map.put(temp, map.getOrDefault(temp, 0) + 1);
                    if(map.get(temp) > max){
                        res = temp;
                        max = map.get(temp);
                    }
                }
                left = right;
            }
            left++;
        }
        return res;
    }
}
