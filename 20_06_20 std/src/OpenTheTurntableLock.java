/*打开转盘锁
你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 */
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class OpenTheTurntableLock {
    public int openLock(String[] deadends, String target) {
        HashSet<String> dead = new HashSet<>();
        for(String s : deadends){
            dead.add(s);
        }
        if(dead.contains("0000")) return -1;
        Queue<String> queue = new LinkedList<>();
        HashSet<String> visit = new HashSet<>();
        queue.offer("0000");
        visit.add("0000");

        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String change = queue.poll();
                if(change.equals(target)){
                    return count;
                }

                for(int j = 0; j < 4; j++){
                    char c1 = change.charAt(j);
                    char c2 = change.charAt(j);
                    if(c1 == '0'){
                        c1 = '9';
                    }else{
                        c1--;
                    }
                    if(c2 == '9'){
                        c2 = '0';
                    }else{
                        c2++;
                    }

                    StringBuilder str1 = new StringBuilder(change);
                    StringBuilder str2 = new StringBuilder(change);
                    str1.setCharAt(j, c1);
                    str2.setCharAt(j, c2);
                    if(!dead.contains(str1.toString()) && !visit.contains(str1.toString())){
                        queue.offer(str1.toString());
                        visit.add(str1.toString());
                    }
                    if(!dead.contains(str2.toString()) && !visit.contains(str2.toString())){
                        queue.offer(str2.toString());
                        visit.add(str2.toString());
                    }
                }
            }
            count++;
        }

        return -1;
    }
}
