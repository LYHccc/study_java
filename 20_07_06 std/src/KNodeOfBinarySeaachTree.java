/*二叉搜索树的第k个节点
给定一棵二叉搜索树，请找出其中的第k小的结点。
例如，（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 */
import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class KNodeOfBinarySeaachTree {
    private void inOrder(List<TreeNode> list, TreeNode root){
        if(root != null){
            inOrder(list, root.left);
            list.add(root);
            inOrder(list, root.right);
        }
    }

    TreeNode KthNode(TreeNode pRoot, int k){
        if(k == 0 || pRoot == null) return null;
        List<TreeNode> list = new ArrayList<>();
        inOrder(list, pRoot);
        if(k > list.size()) return null;
        return list.get(k - 1);
    }
}
