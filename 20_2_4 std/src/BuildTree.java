//根据一棵树的前序遍历与中序遍历构造二叉树。
//注意:
//你可以假设树中没有重复的元素。

class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int val){
        this.val = val;
    }
}

public class BuildTree {
    int curIndex = 0;
    public TreeNode build(int[] preorder, int[] inorder, int inStart, int inEnd){
        if(inStart > inEnd)
            return null;
        int val = preorder[curIndex++];
        TreeNode root = new TreeNode(val);
        if(inStart == inEnd)
            return root;
        int index = 0;
        for(index = inStart; index < inEnd; index++){
            if(inorder[index] == val) break;
        }
        root.left = build(preorder, inorder, inStart, index - 1);
        root.right = build(preorder, inorder, index + 1, inEnd);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length - 1);
    }
}
