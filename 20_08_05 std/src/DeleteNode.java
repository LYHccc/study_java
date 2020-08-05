/*删除链表中重复节点
题目描述
在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class DeleteNode {
    public ListNode deleteDuplication(ListNode pHead){
        if(pHead == null || pHead.next == null) return pHead;
        ListNode newHead = new ListNode(1);
        newHead.next = pHead;
        ListNode cur = pHead;
        ListNode prev = newHead;
        while(cur != null){
            while(cur.next != null && cur.val != cur.next.val){
                cur = cur.next;
                prev = prev.next;
            }
            while(cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
            }
            if(prev.next != cur){
                prev.next = cur.next;
            }
            cur = cur.next;
        }
        return newHead.next;
    }
}
