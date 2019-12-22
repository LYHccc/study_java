//判断一个树是不是层序二叉树
import java.util.LinkedList;
import java.util.Queue;

public class IsCompleteTree {
    public boolean isCompleteTree(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.offer(root);
        }

        while(!queue.isEmpty()){
            TreeNode topNode = queue.poll();
            if(topNode == null){
                break;
            }
            queue.offer(topNode.left);
            queue.offer(topNode.right);
        }

        while(!queue.isEmpty()){
            TreeNode topNode = queue.poll();
            if(topNode != null){
                return false;
            }
        }
        return true;
    }
}
