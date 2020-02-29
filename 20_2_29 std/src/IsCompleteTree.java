//给定一个二叉树，确定它是否是一个完全二叉树。
//百度百科中对完全二叉树的定义如下：
//若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。（注：第 h 层可能包含 1~ 2h 个节点。）

import java.util.LinkedList;
import java.util.Queue;

public class IsCompleteTree {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node != null){
                    queue.offer(node.left);
                    queue.offer(node.right);
                    if(flag)
                        return false;
                }else{
                    flag = true;
                }
            }
        }
        return true;
    }
}
