public class MyLinkedList{
	public static void buildLinkedLiseHand(){
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
	}
	//遍历链表
	public static void printLinkedList(Node head){
		Node cur = head;
		while(cur != null){
			System.out.println(cur.val);
			cur = cur.next;
		}
	}
	//头插
	public static Node pushFront(Node head, int val){
		Node node = new Node(val);
		node.next = head;
		return node;
	}
	//头删
	public static Node popFront(Node head){
		if(head == null){
			throw new RuntimeException("空链表");
		}
		return head.next;
	}
	//尾插
	public static Node pushBack(Node head, int val){
		Node node = new Node(val);
		if(head == null){
			return node;
		}else{
			Node cur = head;
			while(cur.next != null){
				cur = cur.next;
			}
			cur.next = node;
			return head;
		}
	}
	//尾删
	public static Node popBack(Node head){
		if(head == null){
			throw new RuntimeException("空的");
		}else if(head.next ==	null){
			return null;
		}else{
			Node cur = head;
			while(cur.next.next != null){
				cur = cur.next;
			}
			cur.next = null;
			return head;
		}
	}
	public static void main(String[] args){
		Node head = null;
		/*
		head = pushFront(head, 0);
		head = pushFront(head, 1);
		head = pushFront(head, 2);
		head = pushFront(head, 3);
		printLinkedList(head);
		head = popFront(head);
		printLinkedList(head);
		*/
		head = pushBack(head, 1);
		head = pushBack(head, 2);
		head = pushBack(head, 3);
		printLinkedList(head);
		head = popBack(head);
		printLinkedList(head);
	}
}