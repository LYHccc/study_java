/*对称的二叉树
题目描述
请实现一个函数，用来判断一棵二叉树是不是对称的。
注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class SymmetricTree {
    //判断两个子树是否对称
    private boolean isSymmetricalTree(TreeNode left, TreeNode right){
        if(left == null && right == null)
            return true;
        if(left == null || right == null)
            return false;
        return left.val == right.val && isSymmetricalTree(left.left, right.right)
                && isSymmetricalTree(right.left, left.right);
    }

    private boolean isSymmetrical(TreeNode pRoot){
        if(pRoot == null)
            return true;
        return isSymmetricalTree(pRoot.left, pRoot.right);
    }
}
