/*按之字形顺序打印二叉树
题目描述
请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
第三行按照从左到右的顺序打印，其他行以此类推。
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintBinaryTree {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if(pRoot == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(pRoot);
        int count = 0;
        while(!queue.isEmpty()){
            count++;
            LinkedList<Integer> temp = new LinkedList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(count % 2 == 0){
                    temp.addFirst(node.val);
                }else{
                    temp.add(node.val);
                }
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            ArrayList<Integer> temp2 = new ArrayList<>(temp);
            list.add(temp2);
        }

        return list;
    }
}
