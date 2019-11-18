public class Reversal{
	public static Node buildLinkedLiseHand(){
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		return n1;
	}
	public static void printLinkedList(Node head){
		Node cur = head;
		while(cur != null){
			System.out.println(cur.val);
			cur = cur.next;
		}
	}
	//反转链表
	//建立一个新的空链表头节点为newHead，遍历原链表，每遍历一个对象便将这个对象头插到新链表中
	public static Node reverseLis(Node head){
		//用cur来遍历原链表，newHead是新链表的头节点
		Node cur = head;
		Node newHead = null;
		//循环结束的条件就是遍历完整个链表，即cur为null的时候结束
		while(cur != null){
			Node next = cur.next;        //用next来记录下次cur要遍历的位置
			cur.next = newHead;          //头插入遍历的对象，就是让cur下一个指向的对象的节点为头节点
			newHead = cur;               //插入之后的头节点就变成了cur
			cur = next;                  //cur继续向下遍历
		}
		return newHead;
	}
	public static void main(String[] args){
		Node head = buildLinkedLiseHand();
		printLinkedList(head);
		System.out.println("反转后的链表为:");
		head = reverseLis(head);
		printLinkedList(head);
	}
}