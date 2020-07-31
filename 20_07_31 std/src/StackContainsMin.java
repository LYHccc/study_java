/*包含min函数的栈
定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
import java.util.LinkedList;

public class StackContainsMin {
    private static LinkedList<Integer> min = new LinkedList<>();
    private static LinkedList<Integer> list = new LinkedList<>();
    public void push(int node) {
        if(min.size() == 0 || min.getLast() >= node){
            min.add(node);
        }
        list.add(node);
    }

    public void pop() {
        if(list.size() == 0){
            return;
        }
        if(list.getLast() == min.getLast()){
            min.removeLast();
        }
        list.removeLast();
    }

    public int top() {
        return list.getLast();
    }

    public int min() {
        return  min.getLast();
    }
}
