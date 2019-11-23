//输入两个链表，找出它们的第一个公共结点
public class Intersect {
    //求链表的长度
    public static int lengthToList(Node head){
        Node cur = head;
        int count = 0;
        while(cur != null){
            cur = cur.next;
            count++;
        }
        return count;
    }
    public static Node intersectList(Node l1, Node l2){
        Node cur1 = l1;
        Node cur2 = l2;
        //如果链表1比链表2长，让链表1向后走到与链表2相同长度的地方
        if(lengthToList(l1) >= lengthToList(l2)){
            int differ = lengthToList(l1) - lengthToList(l2);
            for(int i = 0; i < differ; i++){
                cur1 = cur1.next;
            }
        }
        //如果链表2比链表1长，让链表2向后走到与链表1长度相同的地方
        if(lengthToList(l1) < lengthToList(l2)){
            int differ = lengthToList(l2) - lengthToList(l1);
            for(int i = 0; i < differ; i++){
                cur2 = cur2.next;
            }
        }
        //如果两个节点不指向同一个对象，继续向下遍历，如果指向同一个对象结束
        while(cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
}
