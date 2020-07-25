/*从上往下打印二叉树
题目描述
从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class PrintBinaryTree {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }

        return list;
    }
}
