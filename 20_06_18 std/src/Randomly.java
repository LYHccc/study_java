/*单词接龙
给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
每次转换只能改变一个字母，换过程中的中间单词必须是字典中的单词。
说明:
如果不存在这样的转换序列，返回 0。所有单词具有相同的长度，所有单词只由小写字母组成，字典中不存在重复的单词。
你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 */
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Randomly {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words = new HashSet<>();
        for(String s : wordList){
            words.add(s);
        }
        HashSet<String> visit = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int count = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String word = queue.poll();
                for(int j = 0; j < word.length(); j++){
                    StringBuilder str = new StringBuilder(word);
                    for(char c = 'a'; c <= 'z'; c++){
                        str.setCharAt(j, c);
                        if(!words.contains(str.toString()) || visit.contains(str.toString())){
                            continue;
                        }
                        if(endWord.equals(str.toString())){
                            return count + 1;
                        }
                        queue.offer(str.toString());
                        visit.add(str.toString());
                    }
                }
            }
            count++;
        }
        return 0;
    }
}
