//栈的实现
import java.util.Arrays;

public class Stack {
    private int[] array;
    private int size;

    public Stack(int n){
        array = new int[n];
        size = 0;
    }

    public void push(int val){
        if(size == array.length){
            array = Arrays.copyOf(array, 2 * size);
        }
        array[size++] = val;
    }

    public void pop(){
        if(size > 0){
            size--;
        }
    }

    public int peek(){
        return array[size - 1];
    }

    public int size(){
        return size;
    }

    public boolean empty(){
        if(size == 0){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack(2);
        System.out.println(s.size());
        System.out.println(s.empty());

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println(s.size());
        System.out.println(s.empty());

        System.out.println("top:" + s.peek());
        System.out.println("遍历栈:");

        while(!s.empty()){
            System.out.println(s.peek());
            s.pop();
        }
        System.out.println(s.size());
        System.out.println(s.empty());
    }
}
