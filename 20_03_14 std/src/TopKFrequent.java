//给一非空的单词列表，返回前 k 个出现次数最多的单词。
//返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
import java.util.*;

public class TopKFrequent {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String s : words){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return map.get(s1) == map.get(s2) ? s2.compareTo(s1) : map.get(s1) - map.get(s2);
            }
        });
        for(String s : map.keySet()){
            queue.offer(s);
            if(queue.size() > k){
                queue.poll();
            }
        }
        List<String> list = new LinkedList<>();
        while(!queue.isEmpty()){
            list.add(0, queue.poll());
        }
        return list;
    }
}
