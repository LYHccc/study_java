package doubly_list;

public class MyLinkedList {
    private Node head = null;
    private Node last = null;
    private int size = 0;
    //头插
    public void pushFront(int val){
        Node node = new Node(val);
        if(head == null){
            head = node;
            last = head;
        }else{
        node.next = head;
        head.prev = node;
        head = node;
        }
        size++;
    }
    //头删
    public void popFront(){
        if(head == null){
            throw new RuntimeException("空了");
        }
        if(head.next == null){
            head = null;
        }else{
            head = head.next;
            head.prev = null;
        }
        size--;
    }
    //尾插
    public void pushBack(int val){
        Node node = new Node(val);
        if(head == null){
            head = node;
            last = head;
        }else{
            last.next = node;
            node.prev = last;
            last = node;
        }
        size++;
    }
    //尾删
    public void popBack(){
        if(head == null){
            throw new RuntimeException("空的");
        }
        if(head.next == null){
            head = null;
        }else{
            last.prev.next = null;
            last = last.prev;
        }
        size++;
    }

    //清空链表
    public void reset(){
        head = null;
        last = null;
        size = 0;
    }

    @Override
    public String toString(){
        String s = " ";
        for(Node cur = head; cur != null; cur = cur.next){
            s += String.format("%d--> ", cur.val);
        }
        s += "null";
        return s;
    }
    
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.pushFront(1);
        list.pushFront(2);
        list.pushFront(3);
        list.pushFront(4);
        System.out.println(list);       //4 3 2 1 null
        list.reset();
        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);
        list.pushBack(4);
        System.out.println(list);        //1 2 3 4 null
        list.popFront();
        list.popFront();
        list.popFront();
        System.out.println(list);        //4 null
        list.popFront();
        System.out.println(list);        //null
        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);
        list.pushBack(4);
        System.out.println(list);        //1 2 3 4 null
        list.popBack();
        list.popBack();
        list.popBack();
        System.out.println(list);         //1 null
        list.popBack();
        System.out.println(list);         //null
    }
}
