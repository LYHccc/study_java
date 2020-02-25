//二叉树的后序遍历(非递归方法二)
import java.util.Stack;

class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int val){
        this.val = val;
    }
}
public class PostorderTraversal {
    public void postorderTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode prev = null;
        while(node != null || !stack.isEmpty()){
            while(node != null){
                //访问左子树
                stack.push(node);
                node = node.left;
            }
            //判断栈顶元素(根)
            node = stack.peek();
            //1.如果此时的根的右子树为空node.right == null
            //2.如果此时的根的右子树已经访问过了node.right == prev(prev记录的是上次访问打印的节点)
            if(node.right == null || node.right == prev){
                //打印根节点，并出栈，将打印过的节点从栈中删除
                stack.pop();
                System.out.println(node.val);
                //记录prev，表示以当前prev为根的子树已经访问过了
                prev = node;
                //node置null就不会再次访问以node为根节点的左右子树，这里的node既然已经打印，说明它的左右子树早已访问完毕
                node = null;
            }else{
                //访问右子树
                node = node.right;
            }
        }
    }
}
