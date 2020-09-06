/**
 * 链表公共部分
 * 自定义链表，给定两个降序排序的链表，找出他们的公共部分
 * 输入描述：
 * 第一行一个数字n代表第一个链表的节点个数
 * 第二行n个数字代表第一个链表的所有节点的value
 * 第三行一个数字m代表第二个链表的节点个数
 * 第四行m个数字代表第二个链表的所有节点的value
 */
package Test3;

import java.util.Scanner;

class Node{
    int value;
    Node next;
    public Node(int value){
        this.value = value;
    }
}
public class Main {
    private static Node find(Node head1, Node head2){
        Node head = new Node(0);
        Node cur1 = head1;
        Node cur2 = head2;
        Node cur = head;
        while(cur1 != null && cur2 != null){
            if(cur1.value == cur2.value){
                cur.next = new Node(cur1.value);
                cur = cur.next;
                cur1 = cur1.next;
                cur2 = cur2.next;
            }else if(cur1.value > cur2.value){
                cur1 = cur1.next;
            }else{
                cur2 = cur2.next;
            }
        }
        cur.next = null;
        return head.next;
    }

    private static void print(Node head){
        Node cur = head;
        while(cur != null){
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node head1 = null;
        Node cur1 = null;
        for(int i = 0; i < n; i++){
            if(head1 == null){
                head1 = new Node(scanner.nextInt());
                cur1 = head1;
            }else{
                cur1.next = new Node(scanner.nextInt());
                cur1 = cur1.next;
            }
        }
        cur1.next = null;
        int m = scanner.nextInt();
        Node head2 = null;
        Node cur2 = null;
        for(int i = 0; i < m; i++){
            if(head2 == null){
                head2 = new Node(scanner.nextInt());
                cur2 = head2;
            }else{
                cur2.next = new Node(scanner.nextInt());
                cur2 = cur2.next;
            }
        }
        cur2.next = null;
        print(find(head1, head2));
    }
}
