//以给定值x为基准将链表分割成两部分，所有小于x的节点排在大于或等于x的节点之前
public class Partition {
    public static Node buildLinkedLiseHand(){
        Node n1 = new Node(8);
        Node n2 = new Node(6);
        Node n3 = new Node(7);
        Node n4 = new Node(4);
        Node n5 = new Node(2);
        Node n6 = new Node(9);
        Node n7 = new Node(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        return n1;
    }

    //遍历链表
    public static void printLinkedList(Node head){
        Node cur = head;
        while(cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
    public static Node partition(Node head, int x){
        Node cur = head;
        Node smallhead = null;
        Node smalllast = null;
        Node bighead = null;
        Node biglast = null;
        while(cur != null){
            if(cur.val < x){
                if(smallhead == null){
                    smallhead = cur;
                }else{
                    smalllast.next = cur;
                }
                smalllast = cur;
                cur = cur.next;
            }else{
                if(bighead == null){
                    bighead = cur;
                }else{
                    biglast.next = cur;
                }
                biglast = cur;
                cur = cur.next;
            }
        }
        if(smallhead == null){
            return head;
        }
        if(bighead == null){
            return head;
        }
        smalllast.next = bighead;
        biglast = null;
        return smallhead;
    }
    public static void main(String[] args){
        Node head = buildLinkedLiseHand();
        head = partition(head, 5);
        printLinkedList(head);
    }
}
