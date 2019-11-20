//反转链表
public class ReverseList {
    public static Node bulidList(){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        return n1;
    }
    public static void printList(Node head){
        Node cur = head;
        while(cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
    public static Node reverseList(Node head){
        Node cur = head;
        Node newHead = null;
        while(cur != null){
            Node next = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = next;
        }
        return newHead;
    }
    public static void main(String[] args){
        Node head = bulidList();
        printList(head);
        System.out.println("反转后的链表是:");
        head = reverseList(head);
        printList(head);
    }
}
