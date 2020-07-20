/*两个链表的第一个公共节点
题目描述：
输入两个链表，找出它们的第一个公共结点。
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class TheFirstPublicNode {
    private int getLength(ListNode head){
        ListNode cur = head;
        int len = 0;
        while(cur != null){
            cur = cur.next;
            len++;
        }
        return len;
    }

    private ListNode walk(ListNode head, int len){
        for(int i = 0; i < len; i++){
            head = head.next;
        }
        return head;
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(getLength(pHead1) > getLength(pHead2)){
            pHead1 = walk(pHead1, getLength(pHead1) - getLength(pHead2));
        }else{
            pHead2 = walk(pHead2, getLength(pHead2) - getLength(pHead1));
        }
        while(pHead1 != pHead2){
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;
    }
}
