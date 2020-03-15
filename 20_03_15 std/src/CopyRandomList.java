//给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
//要求返回这个链表的 深拷贝。 
//我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
//val：一个表示 Node.val 的整数。
//random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyRandomList {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node cur = head;
        while(cur != null){
            Node next = cur.next;
            Node copy = new Node(cur.val);
            cur.next = copy;
            copy.next = next;
            cur = next;
        }
        cur = head;
        Node copy = cur.next;
        while(cur != null){
            Node next = copy.next;
            if(cur.random != null){
                copy.random = cur.random.next;
            }else{
                copy.random = null;
            }
            cur = next;
            if(cur != null){
                copy = cur.next;
            }
        }
        cur = head;
        Node newHead = cur.next;
        copy = newHead;
        while(cur != null){
            Node next = copy.next;
            cur.next = next;
            if(next != null){
                copy.next = next.next;
            }
            cur = next;
            if(cur != null){
                copy = cur.next;
            }
        }
        return newHead;
    }
}
