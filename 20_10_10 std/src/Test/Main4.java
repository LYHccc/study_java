/**
 * 完全二叉树的权值
 * 给定一棵包含N个节点的完全二叉树，树上每个节点都有一个权值
 * 按从上到下、从左到右的顺序依次是A1，A2,·…- Aw
 * 现在小明要把相同深度的节点的权值加在一起，他想知道哪个深度的节点权值之和最大?
 * 如果有多个深度的权值和同为最大，请你输出其中最小的深度。
 */
package Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main4 {
    private static int getDeep(int[] arr){
        Queue<Integer> queue = new LinkedList<>();//队列中存放节点的下标
        queue.offer(0);
        int deep = 1;
        int res = 1;
        int max = arr[0];
        while(!queue.isEmpty()){
            int size = queue.size();
            int sum = 0;
            for(int i = 0; i < size; i++){
                int index = queue.poll();//当前节点下标
                sum += arr[index];
                int child1 = index * 2 + 1;//左孩子
                int child2 = index * 2 + 2;//右孩子
                if(child1 < arr.length){
                    queue.offer(child1);
                }
                if(child2 < arr.length){
                    queue.offer(child2);
                }
            }
            if(sum > max){
                max = sum;
                res = deep;
            }
            deep++;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//节点个数
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println(getDeep(arr));
    }
}
