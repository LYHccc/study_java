/*链表中环的入口节点
给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class EntryNodeOfList {
    public ListNode EntryNodeOfLoop(ListNode pHead){
        ListNode fast = pHead;
        ListNode low = pHead;
        //找到相遇点，快指针一次走两步，慢指针一次一步
        while(fast != null){
            fast = fast.next;
            if(fast == null) return null;
            fast = fast.next;
            low = low.next;
            if(fast == low)
                break;
        }
        //找到相遇点之后一个从相遇点开始，一个从头节点开始，都是一次一步，再次相遇的点为入口节点
        ListNode meet = fast;
        fast = pHead;
        while(fast != low){
            fast = fast.next;
            low = low.next;
        }

        return fast;
    }
}
