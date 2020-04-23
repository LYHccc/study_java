/*链式A + B
题目描:述
有两个用链表表示的整数，每个结点包含一个数位。这些数位是反向存放的，也就是个位排在链表的首部。
编写函数对这两个整数求和，并用链表形式返回结果。

给定两个链表ListNode* A，ListNode* B，请返回A+B的结果(ListNode*)。
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Plus {
    public ListNode plusAB(ListNode a, ListNode b) {
        if(a == null) return b;
        if(b == null) return a;
        ListNode curA = a;
        ListNode curB = b;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int carry = 0;
        while(curA != null && curB != null){
            int num = curA.val + curB.val + carry;
            carry = num / 10;
            num = num % 10;
            ListNode node = new ListNode(num);

            cur.next = node;
            cur = cur.next;
            curA = curA.next;
            curB = curB.next;
        }

        while(curA != null){
            int num = curA.val + carry;
            carry = num / 10;
            num = num % 10;
            ListNode node = new ListNode(num);

            cur.next = node;
            cur = cur.next;
            curA = curA.next;
        }

        while(curB != null){
            int num = curB.val + carry;
            carry = num / 10;
            num = num % 10;
            ListNode node = new ListNode(num);

            cur.next = node;
            cur = cur.next;
            curB = curB.next;
        }

        if(carry != 0){
            ListNode node = new ListNode(carry);
            cur.next = node;
            cur = cur.next;
        }

        return head.next;
    }
}