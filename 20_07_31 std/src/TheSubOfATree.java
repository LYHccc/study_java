/*树的子结构
题目描述
输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class TheSubOfATree {
    private static boolean result;
    private static boolean isChildConstruction(TreeNode root1, TreeNode root2){
        if(root2 == null) return true;
        if(root1 == null) return false;
        if(root1.val == root2.val){
            return isChildConstruction(root1.left, root2.left) && isChildConstruction(root1.right, root2.right);
        }else{
            return false;
        }
    }

    public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null) return false;
        if(root1.val == root2.val){
            result = isChildConstruction(root1, root2);
        }
        if(!result){
            result =  HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(9);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.left = node6;
        node5.right = node7;

        TreeNode root1 = new TreeNode(8);
        TreeNode root2 = new TreeNode(9);
        TreeNode root3 = new TreeNode(2);
        root1.left = root2;
        root1.right = root3;

        System.out.println(HasSubtree(node1, root1));
    }
}
