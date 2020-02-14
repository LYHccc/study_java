//给定一个 N 叉树，返回其节点值的后序遍历。(递归和迭代实现)
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrder {
    //方法一：递归
    public void post(Node root, List<Integer> list){
        if(root != null){
            for(int i = 0; i < root.children.size(); i++){
                post(root.children.get(i), list);
            }
            list.add(root.val);
        }
    }
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        post(root, list);
        return list;
    }


    //方法二：迭代
    /*
    public List<Integer> postorder(Node root) {
        Stack<Node> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;
        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            list.add(0, node.val);
            for(int i = 0; i < node.children.size(); i++){
                if(node.children.get(i) != null){
                    stack.push(node.children.get(i));
                }
            }
        }
        return list;
    }
    */
}
