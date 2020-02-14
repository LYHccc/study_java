//给定一个 N 叉树，返回其节点值的前序遍历。(递归和迭代分别实现)
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node {
    public int val;
    public List<Node> children;
    public Node(){}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class PreOrder {
    //方法一：递归
    public void pre(Node root, List<Integer> list){
        if(root != null){
            list.add(root.val);
            for(int i = 0; i < root.children.size(); i++){
                pre(root.children.get(i), list);
            }
        }
    }
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        pre(root, list);
        return list;
    }


    //方法二：迭代
    /*
    public List<Integer> preorder(Node root) {
        Stack<Node> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;
        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            list.add(node.val);
            for(int i = node.children.size() - 1; i >= 0; i--){
                if(node.children.get(i) != null){
                    stack.push(node.children.get(i));
                }
            }
        }
        return list;
    }
    */
}


