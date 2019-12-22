//给定一个二叉树，检查它是否是镜像对称的。
public class IsSymmetric {
    public boolean isSymmetric1(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right ==null){
            return false;
        }
        return left.val == right.val && isSymmetric1(left.left, right.right)
                && isSymmetric1(left.right, right.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        if(isSymmetric1(root.left, root.right)){
            return true;
        }
        return false;
    }
}
