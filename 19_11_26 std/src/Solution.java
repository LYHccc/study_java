//给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
//请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性
public class Solution {
    public static Node buildLinkedLiseHand(){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        return n1;
    }
    public static void printLinkedList(Node head){
        Node cur = head;
        while(cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
    public Node oddEvenList(Node head) {
        if(head == null || head.next == null){
            return head;
        }
        Node cur = head;
        Node oddHead = new Node(0);          //奇数结点的头结点
        Node oddLast = oddHead;                  //奇数结点的尾结点
        Node evenHead = new Node(0);         //偶数结点的头结点
        Node evenLast = evenHead;                //偶数结点的尾结点
        int count = 1;                           //count用来表示遍历到链表的哪个位置
        //循环结束条件就是遍历完整个链表
        while(cur != null){
            //Node指向当前cur指向的位置
            Node node = cur;
            //如果当前遍历到奇结点，将Node尾插到奇数链表的尾结点之后
            //同理遍历到偶结点也是一样
            if(count % 2 != 0){
                oddLast.next = node;
                oddLast = node;
            }else{
                evenLast.next = node;
                evenLast = node;
            }
            cur = cur.next;
            count++;
        }
        //将奇链表与偶链表连接
        oddLast.next = evenHead.next;
        //让最后一个结点之后指向为空
        if(evenLast.next != null){
            evenLast.next = null;
        }
        return oddHead.next;
    }
}
