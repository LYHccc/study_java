//队列的实现
class Node{
    public int val;
    public Node next;

    public Node(){
    }

    public Node(int val){
        this.val = val;
    }
}

public class Queue {
    Node front;
    Node rear;
    int size;

    public Queue(){
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void offer(int val){
        Node node = new Node(val);
        if(front == null){
            front = rear = node;
        }
        rear.next = node;
        rear = node;
        size++;
    }

    public void poll(){
        if(front == null){
            return;
        }
        front = front.next;
        if(front == null){
            rear = null;
        }
        size--;
    }

    public int peek(){
        if(front == null){
            return -1;
        }
        return front.val;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        System.out.println(q.size());
        System.out.println(q.isEmpty());

        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        System.out.println(q.size());
        System.out.println(q.isEmpty());

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.poll();
        }
        System.out.println(q.size());
        System.out.println(q.isEmpty());
    }
}
