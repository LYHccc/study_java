//给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
import java.util.ArrayList;
import java.util.List;

class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int val){
        this.val = val;
    }
}
public class FindTarget {
    public void inOrder(TreeNode root, List<Integer> list){
        if(root != null){
            inOrder(root.left, list);
            list.add(root.val);
            inOrder(root.right, list);
        }
    }
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        for(int i = 0; i < list.size(); i++){
            for(int j = i + 1; j < list.size(); j++){
                if(list.get(i) + list.get(j) == k)
                    return true;
            }
        }
        return false;
    }
}
