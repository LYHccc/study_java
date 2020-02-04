//根据一棵树的中序遍历与后序遍历构造二叉树。
//注意:
//你可以假设树中没有重复的元素。

public class BuildTree2 {
    int curIndex;
    public TreeNode build(int[] inorder,int[] postorder,int inStart,int inEnd){
        if(inStart > inEnd) return null;
        int val = postorder[curIndex--];
        TreeNode root = new TreeNode(val);
        if(inStart == inEnd) return root;
        int index = 0;
        for(index = inEnd; index >= inStart; index--){
            if(inorder[index] == val) break;
        }
        root.right = build(inorder, postorder, index + 1, inEnd);
        root.left = build(inorder, postorder, inStart, index - 1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        curIndex = postorder.length - 1;
        return build(inorder, postorder, 0, inorder.length - 1);
    }
}
