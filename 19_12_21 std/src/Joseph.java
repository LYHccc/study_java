//约瑟夫问题是一个著名的趣题。这里我们稍稍修改一下规则。
// 有n个人站成一列。并从头到尾给他们编号，第一个人编号为1。
// 然后从头开始报数，第一轮依次报1，2，1，2...然后报到2的人出局。
// 接着第二轮再从上一轮最后一个报数的人开始依次报1，2，3，1，2，3...报到2，3的人出局。
// 以此类推直到剩下以后一个人。现在需要求的即是这个人的编号。
//给定一个int n，代表游戏的人数。请返回最后一个人的编号
class Node{
    Node next;
    int val;

    Node(int val){
        this.val = val;
    }
}
public class Joseph {
    public int getResult(int n) {
        Node head, temp, prev;
        prev = head = temp = new Node(1);
        for(int i = 2; i <= n; i++){
            temp.next = new Node(i);
            temp = temp.next;
        }
        temp.next = head;

        int k = 2;
        while(n != 1){
            temp = prev;
            int size = n;
            for(int i = 1, count = 1; i <= size; i++, count++){
                if(count == 1){
                    prev = temp;
                    temp = temp.next;
                    continue;
                }
                if(count == k){
                    count = 0;
                }
                prev.next = temp.next;
                temp = temp.next;
                n--;
            }
            k++;
        }
        return temp.val;
    }
}