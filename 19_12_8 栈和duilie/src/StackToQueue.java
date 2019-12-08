//使用栈实现队列的下列操作：
//push(x) -- 将一个元素放入队列的尾部。
//pop() -- 从队列首部移除元素。
//peek() -- 返回队列首部的元素。
//empty() -- 返回队列是否为空。

import java.util.LinkedList;
import java.util.Stack;

public class StackToQueue {
    private Stack<Integer> setStack;
    private Stack<Integer> putStack;

    public StackToQueue() {
        setStack = new Stack<>();
        putStack = new Stack<>();
    }

    public void push(int x){
        setStack.push(x);
    }

    public int pop(){
        int size = setStack.size();
        if(putStack.isEmpty()){
            for(int i = 0; i < size; i++){
                putStack.push(setStack.pop());
            }
        }
        return putStack.pop();
    }

    public int peek(){
        //注意此处放入的栈长度必须先记录下来，再在循环中去用，如果直接在循环栈中用setStack.size()是错的，
        // 因为出去一个元素，长度会变小循环就会出错
        int size = setStack.size();
        if(putStack.isEmpty()){
            for(int i = 0; i < size; i++){
                putStack.push(setStack.pop());
            }
        }
        return putStack.peek();
    }

    public boolean empty(){
        return setStack.isEmpty() && putStack.isEmpty();
    }

    public static void main(String[] args) {
        StackToQueue p = new StackToQueue();
        p.push(1);
        p.push(2);
        System.out.println(p.peek());
        System.out.println(p.pop());
    }
}
