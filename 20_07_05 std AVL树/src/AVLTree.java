import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node{
    int key;
    int bf;//平衡因子
    Node left;
    Node right;
    Node parent;//记录结点的父结点，如果结点是根结点，则 parent == null

    Node(int key, Node parent) {
        this.key = key;
        this.bf = 0;
        this.left = null;
        this.right = null;
        this.parent = parent;
    }
}

public class AVLTree {
    //根节点， 如果是空树，root = null
    Node root = null;

    //查找，AVL树中是否包含这个key
    public boolean contains(int key){
        Node cur = root;
        while(cur != null){
            if(cur.key == key){
                return true;
            }else if(cur.key > key){
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }

        return false;
    }

    //向AVL树中插入key
    public void insert(int key){
        if(root == null){
            Node node = new Node(key, null);
            root = node;
            return;
        }

        Node parent = null;
        Node cur = root;
        //寻找key该插入的位置，并判断树中是否已经存在key
        while(cur != null){
            if(cur.key == key){
                throw new RuntimeException("树中已经存在(" + key + ")无法插入");
            }else if(cur.key > key){
                parent = cur;
                cur = cur.left;
            }else{
                parent = cur;
                cur = cur.right;
            }
        }

        //找到插入的位置了，进行插入
        Node node = new Node(key, parent);
        if(key < parent.key){
            cur = parent.left = node;
        }else{
            cur = parent.right = node;
        }

        /**
         * 树的调整
         * 1.如果插入破坏了树的结构，进行调整
         * 2.平衡因子的调整
         */
        while(true){
            if(cur == parent.left){
                parent.bf++;
            }else{
                parent.bf--;
            }

            if(parent.bf == 0){
                break;
            }else if(parent.bf == 2){
                if(cur.bf == 1){//左左失衡调整
                    fixLeftLeftLoseBalance(parent);
                }else{//左右失衡调整
                    fixLeftRightLoseBalance(parent);
                }
                break;
            }else if(parent.bf == -2){
                if(cur.bf == -1){//右右失衡调整
                    fixRightRightLoseBalance(parent);
                }else{//右左失衡调整
                    fixRightLeftLoseBalance(parent);
                }
                break;
            }else if(parent == root){//调整到根节点了
                break;
            }

            //parent.bf == 1向根节点蔓延
            cur = parent;
            parent = parent.parent;
        }
    }

    //右左失衡
    private void fixRightLeftLoseBalance(Node parent) {
        Node rightOfParent = parent.right;//失衡节点的右节点
        Node leftOfrightOfParent = rightOfParent.left;//破坏源的根节点
        //先让失衡节点的右节点右旋
        rightRotate(rightOfParent);
        //再让失衡节点左旋
        leftRotate(parent);

        if(leftOfrightOfParent.bf == 1){//插入位置在破还源根节点左边
            parent.bf = 0;
            rightOfParent.bf = -1;
            leftOfrightOfParent.bf = 0;
        }else if(leftOfrightOfParent.bf == -1){//插入位置在破坏源根节点右边
            parent.bf = 1;
            rightOfParent.bf = 0;
            leftOfrightOfParent.bf = 0;
        }else{//插入位置是破坏源根节点
            parent.bf = rightOfParent.bf = leftOfrightOfParent.bf = 0;
        }
    }
    //右右失衡
    private void fixRightRightLoseBalance(Node parent) {
        Node right = parent.right;
        //失衡节点左旋
        leftRotate(parent);
        right.bf = parent.bf = 0;
    }
    //左右失衡
    private void fixLeftRightLoseBalance(Node parent) {
        Node leftOfParent = parent.left;//失衡节点的左节点
        Node rightOfLeftOfParent = leftOfParent.right;//破坏源的根节点
        //先让失衡节点的左节点左旋
        leftRotate(leftOfParent);
        //再让失衡节点右旋
        rightRotate(parent);

        if(rightOfLeftOfParent.bf == 1){//插入位置在破还源根节点左边
            parent.bf = -1;
            leftOfParent.bf = 0;
            rightOfLeftOfParent.bf = 0;
        }else if(rightOfLeftOfParent.bf == -1){//插入位置在破坏源根节点右边
            parent.bf = 0;
            leftOfParent.bf = 1;
            rightOfLeftOfParent.bf = 0;
        }else{//插入位置是破坏源根节点
            parent.bf = leftOfParent.bf = rightOfLeftOfParent.bf = 0;
        }
    }
    //左左失衡
    private void fixLeftLeftLoseBalance(Node parent) {
        Node left = parent.left;
        //失衡节点右旋
        rightRotate(parent);
        left.bf = parent.bf = 0;
    }


    //左旋
    private void leftRotate(Node parent){
        Node parentOfParent = parent.parent;
        Node right = parent.right;
        Node leftOfRight = right.left;

        right.parent = parentOfParent;
        if(parentOfParent == null){
            root = right;
        }else if(parent == parentOfParent.left){
            parentOfParent.left = right;
        }else{
            parentOfParent.right = right;
        }

        right.left = parent;
        parent.parent = right;

        parent.right = leftOfRight;
        if(leftOfRight != null){
            leftOfRight.parent = parent;
        }
    }

    //右旋
    private void rightRotate(Node parent){
        Node parentOfParent = parent.parent;
        Node left = parent.left;
        Node rightOfLeft = left.right;

        left.parent = parentOfParent;
        if(parentOfParent == null){
            root = left;
        }else if(parent == parentOfParent.left){
            parentOfParent.left = left;
        }else{
            parentOfParent.right = left;
        }

        left.right = parent;
        parent.parent = left;

        parent.left = rightOfLeft;
        if(rightOfLeft != null){
            rightOfLeft.parent = parent;
        }
    }

    public void checkout() {
        List<Integer> inOrderList = new ArrayList<>();
        // 计算该数的中序遍历
        inOrder(inOrderList, root);
        // 如何判断其是否有序呢？  把得到中序序列排序，如果排序后的结果和原来的结果一样，说明原来就有序
        List<Integer> inOrderListCopy = new ArrayList<>(inOrderList);
        Collections.sort(inOrderListCopy);

        if (!inOrderListCopy.equals(inOrderList)) {
            throw new RuntimeException("AVL 树规则不满足：中序遍历无序");
        }
        System.out.println("中序有序：验证OK");

        // 验证每个结点的 BF 是否计算正确
        preOrderAndCalcBF(root);
        System.out.println("BF 计算正确性: 验证OK");

        // 验证每个结点的 BF 是否都是 (-1, 0, 1)
        preOrderAndVerifyBF(root);
        System.out.println("BF 满足AVL特性: 验证OK");
    }

    private void preOrderAndVerifyBF(Node node) {
        if (node != null) {
            if (node.bf != -1 && node.bf != 0 && node.bf != 1) {
                throw new RuntimeException("结点(" + node.key + ")的 BF 是 " + node.bf);
            }

            preOrderAndVerifyBF(node.left);
            preOrderAndVerifyBF(node.right);
        }
    }

    private void preOrderAndCalcBF(Node node) {
        if (node != null) {
            int left = getHight(node.left);
            int right = getHight(node.right);
            if (left - right != node.bf) {
                throw new RuntimeException("结点(" + node.key + ")的 BF 计算有错误");
            }

            preOrderAndCalcBF(node.left);
            preOrderAndCalcBF(node.right);
        }
    }

    private int getHight(Node node) {
        if (node == null) {
            return 0;
        }

        int left = getHight(node.left);
        int right = getHight(node.right);
        return Math.max(left, right) + 1;
    }

    private void inOrder(List<Integer> list, Node node) {
        if (node != null) {
            inOrder(list, node.left);
            // 处理 node
            list.add(node.key);
            inOrder(list, node.right);
        }
    }
}
