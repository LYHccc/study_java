//判断一个链表是不是回文结构
public class PalindromeList {
    public static Node buildList(){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(3);
        Node n5 = new Node(2);
        Node n6 = new Node(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        return n1;
    }
    //找到中间结点
    public static Node getMiddle(Node head){
        Node cur = head;
        int count = 0;
        while(cur != null){
            cur = cur.next;
            count ++;
        }
        cur = head;
        for(int i = 0; i < count / 2; i++){
               cur = cur.next;
        }
        return cur;
    }
    //链表逆置
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
    public static boolean chkPalindrome(Node A){
        //找到中间节点
        Node midhead = getMiddle(A);
        //将中间节点开头的链表逆置
        Node rhead = reverseList(midhead);
        Node c1 = A;
        Node c2 = rhead;
        //将原链表与逆置后的链表每个节点指向的对象中的值一一比较，如果有某个节点的值不一样说明不是回文结构
        //循环结束的条件是:链表有一方为空，说明比较完了
        while(c1 != null && c2 != null){
            if(A.val != rhead.val){
                return false;
            }
            c1 = c1.next;
            c2 = c2.next;
        }
        return true;
    }
    public static void main(String[] args){
        Node head = buildList();
        if(chkPalindrome(head)){
            System.out.println("是回文的");
        }else{
            System.out.println("不是回文的");
        }
    }
}
