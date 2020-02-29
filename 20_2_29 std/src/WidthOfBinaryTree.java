//给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
//每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int val){
        this.val = val;
    }
}
public class WidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        queue.offer(root);
        list.add(1);
        int max = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                int curIndex = list.remove(0);
                if(node.left != null){
                    queue.offer(node.left);
                    list.add(curIndex * 2);
                }
                if(node.right != null){
                    queue.offer(node.right);
                    list.add(curIndex * 2 + 1);
                }
            }
            if(list.size() > 1){
                max = Math.max(max, list.get(list.size() - 1) - list.get(0) + 1);
            }
        }
        return max;
    }
}
