public class BalanceBinaryTree {
    private static int getHight(TreeNode root){
        if(root == null)return 0;
        if(root.left == null && root.right == null) return 1;
        return Math.max(getHight(root.left), getHight(root.right)) + 1;
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null) return true;
        int leftHight = getHight(root.left);
        int rightHight = getHight(root.right);
        return Math.abs(leftHight - rightHight) <= 1
                && IsBalanced_Solution(root.left)
                && IsBalanced_Solution(root.right);
    }
}
