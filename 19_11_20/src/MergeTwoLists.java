//合并两个有序链表
public class MergeTwoLists {
    public static Node bulidList1(){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        return n1;
    }
    public static Node bulidList2(){
        Node m1 = new Node(5);
        Node m2 = new Node(6);
        m1.next = m2;
        return m1;
    }
    public static void printList(Node head){
        Node cur = head;
        while(cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
    //合并两个有序链表
    private static Node mergetwolist(Node list1, Node list2){
        //如果有一个链表初始就为空直接返回另一个链表
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        Node cur1 = list1;
        Node cur2 = list2;
        Node newHead = null;
        Node last = null;
        while(cur1 != null && cur2 != null){
            if(cur1.val <= cur2.val){
                if(newHead == null){
                    newHead = cur1;
                }else{
                    last.next = cur1;
                }
                last = cur1;
                cur1 = cur1.next;
            }else{
                if(newHead == null){
                    newHead = cur2;
                }else{
                    last.next = cur2;
                }
                last = cur2;
                cur2 = cur2.next;
            }
        }
        if(cur1 != null){
            last.next = cur1;
        }else{
            last.next = cur2;
        }
        return newHead;
    }
    public static void main(String[] args){
        Node head1 = bulidList1();
        Node head2 = bulidList2();
        Node head = mergetwolist(head1, head2);
        printList(head);
    }
}
