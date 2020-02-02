//二叉树的后序遍历
import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal {
    public void postOrder(TreeNode root, List<Integer> list){
        if(root != null){
            postOrder(root.left, list);
            postOrder(root.right, list);
            list.add(root.val);
        }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode node = root;
        postOrder(root, list);
        return list;
    }
}
