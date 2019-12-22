//二叉树层序遍历
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    public void levelOrderTraversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.offer(root);
        }

        while(!queue.isEmpty()){
            TreeNode topNode = queue.poll();
            System.out.println(topNode.val);
            if(topNode.left != null){
                queue.offer(topNode.left);
            }
            if(topNode.right != null){
                queue.offer(topNode.right);
            }
        }
    }
}
