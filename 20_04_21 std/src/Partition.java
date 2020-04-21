/*链表分割
编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前

给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。
注意：分割以后保持原来的数据顺序不变。
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Partition {
    private static void print(ListNode head) {
        ListNode cur = head;
        while(cur != null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }

    private static ListNode build() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        return node1;
    }

    public static ListNode partition(ListNode pHead, int x) {
        ListNode cur = pHead;
        ListNode newHead = null;
        ListNode small = null;
        ListNode big = null;
        ListNode bigHead = null;

        while(cur != null){
            ListNode node = new ListNode(cur.val);
            if(cur.val < x){
                if(small == null){
                    small = node;
                    newHead = node;
                }else{
                    small.next = node;
                    small = small.next;
                }
            }else{
                if(big == null){
                    big = node;
                    bigHead = node;
                }else{
                    big.next = node;
                    big = big.next;
                }
            }
            cur = cur.next;
        }


        if(small == null){
            newHead = bigHead;
        }else{
            small.next = bigHead;
        }

        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = build();
        System.out.print("原始链表为：");
        print(head);
        System.out.println();
        System.out.print("分割后:");
        print(partition(head, 3));
    }
}