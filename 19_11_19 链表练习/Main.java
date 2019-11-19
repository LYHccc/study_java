class Node{
	int val;
	Node next;
	public Node(int val, Node next){
		this.val = val;
		this.next = next;
	}
	public Node(int val){
		this(val,null);
	}
	@Override
	public String toString(){
		return String.format("Node{%d}", val);
	}
}/*
public class Main{
	//创建、初始化一个链表
	public static Node buildLinkedLiseHand(){
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
	//给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
	//如果有两个中间结点，则返回第二个中间结点。
    public static Node middleNode(Node head) {
		//用cur来遍历来链表，count记录每个节点在链表中的对应位置，mid表示中间节点的位置
        Node cur = head;
        int count = 0;
        int mid = 0;
		//循环结束的条件就是遍历完整个链表，即cur为null的时候结束
        while(cur != null){
            count++;              //循环进行count+1表示这个节点的位置数加一
            cur = cur.next;       //cur指向下一个对象位置
        }
		if(count == 1){           //如果只有一个节点返回头节点
			return head;
		}else{                    //如果不止一个节点
			//再次让cur等于头节点，从第一个数字开始遍历
			cur = head;               
			//计算mid的位置，如果是偶数mid的位置就是中间两个位置中的第二个（比如6/2+1=3+1+4，4是中间位置的第二个）
			//如果是奇数mid的位置就是中间的位置（比如5/2+1=2+1=3，3是中间位置）
			mid = count / 2 + 1;  
			//因为cur = head指向第一个位置，i = 1第一次循环cur会指向第二个节点位置
			//要指向mid的位置i循环完mid-1就可以了
			for(int i = 1; i < mid; i++){
				cur = cur.next;
			}
			return cur;
		}
    }

	public static void main(String[] args){
		Node head = buildLinkedLiseHand();
		printLinkedList(head);
		System.out.println("从中间节点开始，链表为:");
		head = middleNode(head);
		printLinkedList(head);
	}
}
*/

//输入一个链表，输出该链表中倒数第k个结点。
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
		ListNode cur = head;
        int count = 0;
        while(cur != null){
            cur = cur.next;
            count++;
        }
		//如果输入的k范围超过了链表的数目，返回null
        if(k > count){
            return null;
        }else{
            cur = head;
			//链表中最后一个位置即倒数第1个位置为count，
			//那么倒数第k个位置就是count - k + 1
            for(int i = 1; i < (count - k +1); i++){           
                cur = cur.next;
            }
            return cur;
        }
    }
}