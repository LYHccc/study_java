/*约瑟夫问题Ⅱ
题目描述
约瑟夫问题是一个著名的趣题。这里我们稍稍修改一下规则。有n个人站成一列。
并从头到尾给他们编号，第一个人编号为1。
然后从头开始报数，第一轮依次报1，2，1，2...然后报到2的人出局。
接着第二轮再从上一轮最后一个报数的人开始依次报1，2，3，1，2，3...报到2，3的人出局。
以此类推直到剩下以后一个人。现在需要求的即是这个人的编号。

给定一个int n，代表游戏的人数。请返回最后一个人的编号
 */
import java.util.LinkedList;

public class JosephⅡ {
    public static int getResult(int n) {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            list.add(i);
        }

        int num = 2;//循环报数的个数
        while(list.size() > 1){
            int count = 0;//1到num报了几个了
            for(int i = 0; i < list.size(); i++){
                if(count != 0){
                    list.remove(i);
                    i--;
                }
                count = (count + 1) % num;
            }
            num++;
            list.addFirst(list.remove(list.size() - 1));
        }

        return list.get(0);
    }

    public static void main(String[] args) {
        System.out.println(getResult(5));
    }
}
