/*复杂链表的复制
题目描述
输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
另一个特殊指针random指向一个随机节点），请对此链表进行深拷贝，并返回拷贝后的头结点。
（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class CopyLinkedList {
    public RandomListNode Clone(RandomListNode pHead){
        if(pHead == null) return null;
        RandomListNode cur = pHead;
        RandomListNode copy = null;
        //复制节点并链接
        while(cur != null){
            RandomListNode next = cur.next;
            copy = new RandomListNode(cur.label);
            cur.next = copy;
            copy.next = next;
            cur = next;
        }

        //链接随机指针
        cur = pHead;
        while(cur != null){
            copy = cur.next;
            RandomListNode next = copy.next;
            if(cur.random != null)
                copy.random = cur.random.next;
            else
                copy.random = null;
            cur = next;
        }

        //拆链
        cur = pHead;
        RandomListNode newHead = cur.next;
        copy = cur.next;
        while(cur != null){
            RandomListNode next = copy.next;
            cur.next = next;
            if(next != null)
                copy.next = next.next;
            cur = next;
            copy = copy.next;
        }

        return newHead;
    }
}
