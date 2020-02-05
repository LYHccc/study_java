//你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
//空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。

class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int val){
        this.val = val;
    }
}
public class TreeStr {
    //一共要考虑四种情况，
    // 1.左子树和右子树都没有
    // 2.只有左子树，右子树为空
    // 3.左子树为空，只有右子树
    // 4.左右子树都有。
    // 其中 3和4一类处理。
    //写法一：
    public String tree2str(TreeNode t) {
        if(t == null)
            return "";
        if(t.left == null && t.right == null)
            return String.valueOf(t.val);
        if(t.right == null)
            return t.val + "(" + tree2str(t.left) + ")";
        return t.val + "(" + tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";
    }

    /*
    //写法二：
    StringBuilder str = new StringBuilder();
    public void preOrder(TreeNode t){
        if(t == null)
            return;
        if(t.left == null && t.right == null){
            str.append(t.val);
            return;
        }
        if(t.right == null){
            str.append(t.val);
            str.append("(");
            preOrder(t.left);
            str.append(")");
            return;
        }
        str.append(t.val);
        str.append("(");
        preOrder(t.left);
        str.append(")");
        str.append("(");
        preOrder(t.right);
        str.append(")");
        return;
    }
    public String tree2str(TreeNode t) {
        preOrder(t);
        return str.toString();
    }
    */
}
