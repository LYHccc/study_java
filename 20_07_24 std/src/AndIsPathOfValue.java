/*二叉树中和为某一值的路径
题目描述
输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
import java.util.ArrayList;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}

public class AndIsPathOfValue {
    private static ArrayList<ArrayList<Integer>> list;
    private static void dfs(ArrayList<Integer> temp, TreeNode root, int target){
        if(root == null) return;
        target -= root.val;
        temp.add(root.val);
        if(target == 0 && root.left == null && root.right == null){
            list.add(new ArrayList<>(temp));
        }else{
            dfs(temp, root.left, target);
            dfs(temp, root.right, target);
        }
        temp.remove(temp.size() - 1);
    }

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        list = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        dfs(temp, root, target);
        return list;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node2.left = node4;
        node2.left = node5;
        node1.right = node3;
        System.out.println(FindPath(node1, 22));
    }
}
