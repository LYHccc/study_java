//给定一个二叉树，判断它是否是高度平衡的二叉树。
//本题中，一棵高度平衡二叉树定义为：
//一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1
public class IsBalanced {
    public int getHight(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = getHight(root.left);
        int right = getHight(root.right);
        return left > right ? left + 1 : right + 1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int left = getHight(root.left);
        int right = getHight(root.right);
        return Math.abs(left - right) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }
}
