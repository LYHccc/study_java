import java.sql.SQLOutput;

//链表删除重复的结点
public class DeleteDupLication {
    public static Node buildList(){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(3);
        Node n5 = new Node(5);
        Node n6 = new Node(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        return n1;
    }
    //遍历打印链表
    public static void printList(Node head){
        Node cur = head;
        while(cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
    public static Node deleteduplication(Node head){
        //建立一个只存放一个0的链表newHead
        //prev指向新链表的头节点
        //prev.next指向head
        Node newHead = new Node(0);
        Node prev = newHead;
        prev.next = head;
        Node cur = head;
        Node next = head.next;                 //next指向cur的下一个指向
        //如果head为空返回head
        if(head == null){
            return head;
        }
        //如果不为空开始遍历
        //结束条件就是遍历完整个链表即next==null结束
        while(next != null){
            //cur和next指向的值不相同
            if(cur.val != next.val){
                prev = prev.next;
                cur = cur.next;
                next = next.next;
            }else{                              //相同的话
                //如果相等了直接让next向下走直到next为空或者cur和next指向的值不相等
                while(next != null && cur.val ==next.val){
                    next = next.next;
                }
                //删除[cur,next)的节点
                prev.next = next;
                //让cur和next（此时next不为null的话）向下走（到下两个需要判断的对象位置）
                cur = next;
                if(next != null){
                    next = next.next;
                }
            }
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        Node head = buildList();
        printList(head);
        System.out.println("删除重复的节点后:");
        head = deleteduplication(head);
        printList(head);
    }
}
