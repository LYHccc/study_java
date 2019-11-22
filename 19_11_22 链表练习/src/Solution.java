//给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，
// 并且它们的每个节点只能存储一位数字。
//如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

public class Solution {
    public static Node buildList1(){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        return n1;
    }
    public static Node buildList2(){
        Node m1 = new Node(1);
        Node m2 = new Node(2);
        Node m3 = new Node(3);
        Node m4 = new Node(4);
        m1.next = m2;
        m2.next = m3;
        m3.next = m4;
        return m1;
    }
    public static void printList(Node head){
        Node cur = head;
        while(cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
    public static Node addTwoNumbers(Node l1, Node l2) {
        Node cur1 = l1;
        Node cur2 = l2;
        Node newHead = new Node(0);
        Node prev = newHead;
        int carry = 0;
        int n1 = 0;
        int n2 = 0;
        while(cur1 != null || cur2 != null || carry != 0){
            if(cur1 != null){
                n1 = cur1.val;
            }else{
                n1 = 0;
            }
            if(cur2 != null){
                n2 = cur2.val;
            }else{
                n2 = 0;
            }
            int addNum = n1 + n2 + carry;
            carry = addNum / 10;
            Node addNode = new Node(addNum %10);
            prev.next = addNode;
            prev = addNode;

            if(cur1 != null){
                cur1 = cur1.next;
            }
            if(cur2 != null){
                cur2 = cur2.next;
            }
        }
        return newHead.next;
    }
    public static void main(String[] args){
        Node head1 = buildList1();
        Node head2 = buildList2();
        Node head = addTwoNumbers(head1, head2);
        printList(head);
    }
}
