//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

public class LowestCommonAncestor {
    //方法一
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null){
            return root;
        }else if(left != null){
            return left;
        }else{
            return right;
        }
    }
    /*
    //方法二
    public static boolean find(TreeNode root, TreeNode node){
        if(root == null)
            return false;
        if(root == node)
            return true;
        return find(root.left, node) || find(root.right, node);
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return root;
        if(root == p || root == q)
            return root;
        boolean pL = false;
        boolean pR = false;
        boolean qL = false;
        boolean qR = false;
        if(find(root.left, p)){
            pL = true;
        }else{
            pR = true;
        }
        if(find(root.left, q)){
            qL = true;
        }else{
            qR = true;
        }

        if(pL && qL){
            return lowestCommonAncestor(root.left, p, q);
        }else if(pR && qR){
            return lowestCommonAncestor(root.right, p, q);
        }else{
            return root;
        }
    }
    */
}
