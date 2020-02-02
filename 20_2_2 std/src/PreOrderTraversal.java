//二叉树的前序遍历
import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

public class PreOrderTraversal {
    public void preOrder(TreeNode root, List<Integer> list){
        if(root != null){
            list.add(root.val);
            preOrder(root.left, list);
            preOrder(root.right, list);
        }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        TreeNode node = root;
        List<Integer> list = new ArrayList<>();
        preOrder(node, list);
        return list;
    }
}
