//　　给出一列数{pi}={p0, p1, …, pn-1}，用这列数构造Huffman树的过程如下：
//　　1. 找到{pi}中最小的两个数，设为pa和pb，将pa和pb从{pi}中删除掉，然后将它们的和加入到{pi}中。这个过程的费用记为pa + pb。
//　　2. 重复步骤1，直到{pi}中只剩下一个数。
//　　在上面的操作过程中，把所有的费用相加，就得到了构造Huffman树的总费用。
//　　本题任务：对于给定的一个数列，现在请你求出用该数列构造Huffman树的总费用。
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HuffumanTree {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++){
            queue.offer(scanner.nextInt());
        }
        int sum = 0;
        while(queue.size() > 1){
            int a = queue.poll();
            int b = queue.poll();
            sum += a + b;
            queue.offer(a + b);
        }
        System.out.println(sum);
    }
}
