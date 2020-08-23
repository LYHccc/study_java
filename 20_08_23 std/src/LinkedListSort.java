/**
 * 链表排序
 * 给定一个单链表，将所有奇数位置的节点放在偶数位置节点之前
 * 节点下标从1开始
 */
class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val){
        this.val = val;
    }
}

public class LinkedListSort {
    public static ListNode lineUp (ListNode head) {
        if(head == null) return null;
        ListNode cur = head;
        ListNode headList = null;
        ListNode lastList = null;
        ListNode cur1 = null;
        ListNode cur2 = null;
        int index = 1;
        while(cur != null){
            if(index % 2 != 0){
                if(headList == null){
                    headList = cur;
                    cur1 = headList;
                }else{
                    cur1.next = cur;
                    cur1 = cur1.next;
                }
            }else{
                if(lastList == null){
                    lastList = cur;
                    cur2 = lastList;
                }else{
                    cur2.next = cur;
                    cur2 = cur2.next;
                }
            }
            cur = cur.next;
            index++;
        }
        cur2.next = null;
        cur1.next = lastList;

        return headList;
    }

    private static void print(ListNode head){
        ListNode cur = head;
        while(cur != null){
            System.out.println(cur.val + " ");
            cur = cur.next;
        }
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(12);
        ListNode node2 = new ListNode(13);
        ListNode node3 = new ListNode(14);
        ListNode node4 = new ListNode(15);
        ListNode node5 = new ListNode(16);
        ListNode node6 = new ListNode(17);
        ListNode node7 = new ListNode(18);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        print(lineUp(node1));
    }
}
