/*最小基因变化
一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。
现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，
请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。

注意:
起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
所有的目标基因序列必须是合法的。
假定起始基因序列与目标基因序列是不一样的。
 */
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MinGeneticChange {
    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> base = new HashSet<>();//基因库
        for(String s : bank){
            base.add(s);
        }
        HashSet<String> visit = new HashSet<>();//当前这个字符串是否进行过基因变化遍历了
        visit.add(start);
        Queue<String> queue = new LinkedList<>();
        HashSet<Character> charSet = new HashSet<>();
        charSet.add('A');
        charSet.add('C');
        charSet.add('G');
        charSet.add('T');
        queue.offer(start);

        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            //找出当前这一轮的所有字符串可能出现的变化
            for(int i = 0; i < size; i++){
                String head = queue.poll();
                //将字符串每一个字符分别用'A','C','G','T'进行替换
                for(int j = 0; j < head.length(); j++){
                    StringBuilder str= new StringBuilder(head);
                    for(char c : charSet){
                        str.setCharAt(j, c);
                        String temp = str.toString();
                        //如果基因库中没有这个字符串，或者这个字符串已经遍历过(转换已经遍历过，无需再次转换)
                        if(visit.contains(temp) || !base.contains(temp)) continue;
                        //如果转换成功，转换次数加上这一次的转换并返回
                        if(temp.equals(end)){
                            return count + 1;
                        }
                        queue.offer(temp);
                        visit.add(temp);
                    }
                }
            }
            count++;
        }

        return -1;
    }
}
