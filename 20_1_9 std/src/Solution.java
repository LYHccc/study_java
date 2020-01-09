//二叉树搜索树转换成排序双向链表
//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
// 要求不能创建任何新的结点，只能调整树中结点指针的指向。

public class Solution {
    static TreeNode prev = null;
    public void _Convert(TreeNode root){
        if(root == null){
            return;
        }
        _Convert(root.left);
        root.left = prev;
        if(prev != null){
            prev.right = root;
        }
        prev = root;
        _Convert(root.right);
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        prev = null;
        _Convert(pRootOfTree);
        while(pRootOfTree.left != null){
            pRootOfTree = pRootOfTree.left;
        }
        return pRootOfTree;
    }
}
