import java.util.Stack;

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        if(minStack.isEmpty() || x <= minStack.peek()){
            minStack.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        //注意在这栈中类型是包装类的引用，所以直接比较stack.peek()和minStack.peek()的话是判断两个引用是否指向同一个对象，会出错
        //要判断两个栈顶元素是否相同需要先用一个int类型记录一个栈顶的值再去与另一个判断
        //或者调用equals方法判断引用的值是否相同
        int temp = stack.peek();
        if(temp == minStack.peek()){
            minStack.pop();
        }
        /*
        if(stack.peek().equals(minStack.peek())){
            minStack.pop();
        }
        */
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}