//给定一个树，按中序遍历重新排列树，使树中最左边的结点现在是树的根，
// 并且每个结点没有左子结点，只有一个右子结点。

import java.util.ArrayList;
import java.util.List;

public class InCreasingBST {
    public void inOrder(TreeNode root, List<Integer> list){
        if(root != null){
            inOrder(root.left, list);
            list.add(root.val);
            inOrder(root.right, list);
        }
    }
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        TreeNode node = new TreeNode(list.get(0));
        TreeNode cur = node;
        int size = list.size();
        for(int i = 1; i < size; i++){
            cur.right = new TreeNode(list.get(i));
            cur = cur.right;
        }
        return node;
    }
}
