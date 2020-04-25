/*二叉树平衡检查
题目描述：
实现一个函数，检查二叉树是否平衡，平衡的定义如下，对于树中的任意一个结点，其两颗子树的高度差不超过1。

给定指向树根结点的指针TreeNode* root，请返回一个bool，代表这棵树是否平衡。
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class BalanceBinaryTree {
    private int lengthTree(TreeNode root){
        if(root == null) return 0;
        return Math.max(lengthTree(root.left), lengthTree(root.right)) + 1;
    }

    public boolean isBalance(TreeNode root) {
        if(root == null) return true;
        if(Math.abs(lengthTree(root.left) - lengthTree(root.right)) > 1){
            return false;
        }
        return isBalance(root.left) && isBalance(root.right);
    }
}
