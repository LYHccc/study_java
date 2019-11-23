//判断一个链表中有没有环
public class Solution {
    public boolean hasCycle(Node head) {
        //如果头结点指向为null说明没有环
        if(head == null){
            return false;
        }
        //定义fast是遍历的比较快的结点，slow是比较慢的
        //fast每次可以向下走两个位置，slow只能走一个
        Node fast = head;
        Node slow = head;
        //fast每走一次就判断fast有没有指向为null，如果指向null说明没有环
        //让fast和slow一直往下个位置遍历，直到fast和slow指向相同说明有环
        //注意:因为让fast和slow开始都指向了头节点所以最开始fast和slow指向是肯定相同的，所以需要先让fast和slow动起来判断完之后，再进行循环
        do{
            fast = fast.next;
            if(fast == null){
                return false;
            }
            fast = fast.next;
            if(fast == null){
                return false;
            }
            slow = slow.next;
        }
        while(fast != slow);
        return true;
    }
}
