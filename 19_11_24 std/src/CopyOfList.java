public class CopyOfList {
    public static Node copy(Node head){
        Node newHead = null;
        Node newLast = null;
        Node cur = head;
        while(cur != null){
            Node node = new Node(cur.val);
            if(newHead == null){
                newHead = node;
            }else{
                newLast.next = node;
            }
            newLast = node;
            cur = cur.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        Node newHead = copy(n1);
        System.out.println("hello");
    }
}
