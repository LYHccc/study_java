//给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
//s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
public class IsSameTree {
    public boolean isSametree(TreeNode s, TreeNode t) {
        if(s == null && t == null){
            return true;
        }
        if(s == null || t == null){
            return false;
        }
        return s.val == t.val && isSametree(s.left, t.left) && isSametree(s.right, t.right);
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null){
            return false;
        }
        if(isSametree(s, t)){
            return true;
        }
        if(isSubtree(s.left, t)){
            return true;
        }
        return isSubtree(s.right, t);
    }
}
