//使用队列实现栈的下列操作：
//push(x) -- 元素 x 入栈
//pop() -- 移除栈顶元素
//top() -- 获取栈顶元素
//empty() -- 返回栈是否为空

import java.util.LinkedList;
import java.util.Queue;

public class QueueToStack {
    private Queue<Integer> setQueue;

    public QueueToStack(){
        setQueue = new LinkedList<>();
    }

    public void push(int x){
        setQueue.offer(x);
    }

    public int pop(){
        for (int i = 0; i < setQueue.size() - 1; i++) {
            int temp = setQueue.poll();
            setQueue.offer(temp);
        }
        return setQueue.poll();
    }

    public int top(){
        for (int j = 0; j < setQueue.size() - 1; j++) {;
            int temp = setQueue.poll();
            setQueue.offer(temp);
        }
        int temp = setQueue.poll();
        setQueue.offer(temp);
        return temp;
    }

    public boolean empty(){
        return setQueue.isEmpty();
    }

    public static void main(String[] args) {
        QueueToStack q = new QueueToStack();
        q.push(1);
        q.push(2);
        System.out.println(q.top());
        System.out.println(q.pop());
        System.out.println(q.empty());
    }
}
