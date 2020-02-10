//给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
//请你找出层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int val){
        this.val = val;
    }
}

public class MaxLevelSum {
    public int maxLevelSum(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int max = root.val;
        int level = 0;
        int maxLevel = 1;
        while(!queue.isEmpty()){
            level++;
            int sum = 0;
            int size = queue.size();
            for(; size > 0; size--){
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            if(sum > max){
                max = sum;
                maxLevel = level;
            }
        }
        return maxLevel;
    }
}
