/*序列化二叉树
请实现两个函数，分别用来序列化和反序列化二叉树
二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。
序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，
序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
例如，我们可以把一个只有根节点为1的二叉树序列化为"1,"，然后通过自己的函数来解析回这个二叉树
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class SerializeBinaryTree {
    private static void inOrder(TreeNode root, StringBuilder str){
        if(root == null){
            str.append("#,");
            return;
        }
        str.append(root.val).append(",");
        inOrder(root.left, str);
        inOrder(root.right, str);
    }
    private static String Serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        inOrder(root, str);
        return str.toString();
    }

    private static int index;
    private static TreeNode DeserializeStr(String[] arr){
        index++;
        TreeNode node = null;
        if(arr[index].equals("#")){
            return node;
        }
        node = new TreeNode(Integer.valueOf(arr[index]));
        node.left = DeserializeStr(arr);
        node.right = DeserializeStr(arr);
        return node;
    }
    private static TreeNode Deserialize(String str) {
        if(str == null) return null;
        String[] arr = str.split(",");
        index = -1;
        return DeserializeStr(arr);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(11);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        String s = Serialize(node1);
        System.out.println(s);
        System.out.println(Deserialize(s));
    }
}
