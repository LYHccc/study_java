public class Main {
    public static void main(String[] args) {
        Solution p = new Solution();
        System.out.println("原链表为");
        Node head = p.buildLinkedLiseHand();
        p.printLinkedList(head);
        System.out.println("奇偶链表为:");
        head = p.oddEvenList(head);
        p.printLinkedList(head);
    }
}
