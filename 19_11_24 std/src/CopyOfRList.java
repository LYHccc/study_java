public class CopyOfRList {
    public static RNode copy(RNode head){
        if(head == null){
            return null;
        }

        RNode cur =head;
        while(cur != null){
            RNode node = new RNode(cur.val);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }

        cur = head;
        while(cur != null){
            if(cur.random != null){
            cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        cur = head;
        RNode newHead = cur.next;
        while(cur != null){
            RNode node = cur.next;
            cur.next = node.next;
            if(cur.next != null) {
                node.next = cur.next.next;
            }
            cur = cur.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        RNode n1 = new RNode(1);
        RNode n2 = new RNode(2);
        RNode n3 = new RNode(3);
        RNode n4 = new RNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n1.random = n2;
        n2.random = n1;
        n3.random = n3;
        RNode newHead = CopyOfRList.copy(n1);
        System.out.println("hello");
    }
}
