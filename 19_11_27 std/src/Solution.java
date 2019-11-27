//给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
public class Solution {
    public static ListNode buildLinkedLiseHand(){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        return n1;
    }
    public static void printLinkedList(ListNode head){
        ListNode cur = head;
        while(cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
    //找到中间结点
    public static ListNode middleNode(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    //反转链表
    public static ListNode reverseList(ListNode head){
        ListNode cur = head;
        ListNode newHead = null;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = next;
        }
        return newHead;
    }
    public static void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode middle = middleNode(head);        //找到中间结点
        ListNode backList = reverseList(middle);   //对中间节点后的链表并对其进行反转
        ListNode cur = head;                       //此时的head最后一个结点是中间结点，
        while(cur.next.next != null){              //尾删掉head中的最后一个结点即原链表的中间结点
            cur = cur.next;
        }
        cur.next = null;
        cur = head;
        ListNode prev = backList;                  //prev指向后半链表反转后的链表
        //将反转后的链表的每个结点插入cur指向的head链表中
        while(cur != null && prev != null){        //如果有一个遍历完了结束循环
            ListNode curnext = cur.next;           //记录此时cur的下个指向
            ListNode prevnext = prev.next;         //记录此时prev的下个指向
            cur.next = prev;
            if(curnext != null){                   //如果下个curnext不为空，即cur还没有遍历完
                prev.next = curnext;               //让prev下一个指向curnext
            }
            cur = curnext;
            prev = prevnext;
        }
    }

    public static void main(String[] args) {
        ListNode head = buildLinkedLiseHand();
        printLinkedList(head);
        System.out.println("重排后的链表:");
        reorderList(head);
        printLinkedList(head);
    }
}
