//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class RightSideView {
    //层序遍历，将每一层的最后一个元素记录下来
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if (root != null)
            queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode topNode = queue.poll();
                if (i == size - 1)
                    list.add(topNode.val);
                if (topNode.left != null)
                    queue.offer(topNode.left);
                if (topNode.right != null)
                    queue.offer(topNode.right);
            }
        }
        return list;
    }
}
