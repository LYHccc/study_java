//删除链表中等于给定值val的所有节点
public class Solution{
	//创建、初始化一个链表
	public static Node buildLinkedLiseHand(){
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(6);
		Node n4 = new Node(3);
		Node n5 = new Node(4);
		Node n6 = new Node(5);
		Node n7 = new Node(6);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		return n1;
	}
	
	//遍历链表
	public static void printLinkedList(Node head){
		Node cur = head;
		while(cur != null){
			System.out.println(cur.val);
			cur = cur.next;
		}
	}
	
	//第一种方法
	//给定val删除与val值相同的节点
	//只要与val值相同的节点的前驱直接指向val值相同节点的下一个节点，就相当于删除了这个节点
	public static Node removeElements(Node head, int val){
		//用cur来遍历链表，让cur指向每个对象
		//prev是val的前驱节点，刚好比cur慢一步
		Node cur = head;
		Node prev = null;
		//循环结束的条件就是遍历完整个链表，即cur为null的时候结束
		while(cur != null){
			if(cur.val == val){            //判断如果此时cur所指向的值等于val，进行下边的操作
				if(cur == head){           
					head = head.next;      //如果此时cur指向与head相同说明链表中第一个数的值等于val，直接跳过这个值，相当于删除掉了这个值
				}else{
					prev.next = cur.next;  //在cur.val == val 的条件下让prev.next指向和cur.next相同的地方（此时prev比cur慢一步，刚好就可以跳过val值所在的节点）
				}
			}else{ 
			prev = cur;                    //如果此时的值不等于val，在这里让prev指向和此时cur指向相同的地方
			}
			cur = cur.next;                //cur指向下个地方，这样就可以刚好让prev比cur慢一步
		}
		return head;
	}
	
	/*
	//第一种方法(2)
	//先判断第一个数是不是等于val，如果等于直接让head = head.next，如果第一个数是空，直接返回null
	public static Node removeElements(Node head, int val){
		if(head == null){
			return null;
		}
		if(head.val == val){
			head = head.next;
		}
		Node cur = head;
		Node prev = null;
		while(cur != null){
			if(cur.val == val){
				prev.next = cur.next;
			}else{
				prev = cur;
			}
			cur = cur.next;
		}
		return head;
	}
	*/
	
	/*
	//第二种方法
	//建立一个新的空链表头节点为newHead，遍历原链表将每个与val值不同的对象节点尾插到新的链表中
	public static Node removeElements(Node head, int val){
		//newHead为新链表的头节点，last是新链表中指向最后一个对象的节点
		Node cur = head;
		Node last = null;
		Node newHead = null;
		//循环结束的条件就是遍历完整个链表，即cur为null的时候结束
		while(cur != null){
			if(cur.val == val){             //如果此时指向的对象的值的关于val，直接跳过这个对象，让cur指向下个对象
				cur = cur.next;
			}else{                          //如果值不等于val，则就要将指向这个对象的节点插入新链表中，执行下边的操作
				if(newHead == null){        //如果新的链表头节点指向为空说明此时新链表中还没有节点，直接插入要插入的节点
					newHead = cur;          //就是让新链表的头节点指向与插入的对象的节点相同
					last = cur;             //此时的last也就会变成新插入的节点
				}else{                      //如果新的链表头节点不为空
					last.next = cur;        //那么就进行尾插，插入节点（就是让上一次的last.next指向等于新插入的节点）
					last = cur;             //此时的last也就会再次变成新插入的节点
				}
				cur = cur.next;             //然后再让cur去指向下一个对象
			}
		}
		if(last != null){                   //如果结束之后的last不为空,说明最后一个数值等于val
			last.next = null;               //此时结束，即让last.next = null;
		}
		return newHead;
	}
	
	*/
	public static void main(String[] args){
		Node head = buildLinkedLiseHand();
		printLinkedList(head);
		System.out.println("删除链表中等于给定值6的所有节点后链表为:");
		head = removeElements(head, 6);
		printLinkedList(head);
	}
}