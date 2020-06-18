/*N叉树的层序遍历
给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class SequenceTravelOfNTree {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < size; i++){
                Node node = queue.poll();
                temp.add(node.val);
                for(Node n : node.children){
                    queue.offer(n);
                }
            }

            list.add(temp);
        }

        return list;
    }
}
