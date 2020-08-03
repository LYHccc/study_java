/*从尾到头打印链表
题目描述
输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
import java.util.ArrayList;
import java.util.LinkedList;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class PrintList {
    /*
    //方法一：遍历头插到LinkedList中，再将值复制到ArrayList
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        LinkedList<Integer> list = new LinkedList<>();
        while(listNode != null){
            list.addFirst(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> res = new ArrayList<>(list);
        return  res;
    }
    */
    //方法二：递归存储
    private static void research(ListNode node, ArrayList<Integer> list){
        if(node == null) return;
        research(node.next, list);
        list.add(node.val);
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        research(listNode, list);
        return list;
    }
}
