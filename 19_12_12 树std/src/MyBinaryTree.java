class Node{
    char val;
    Node left;
    Node right;

    public Node(char val){
        this.val = val;
        left = right = null;
    }
}
public class MyBinaryTree {
    int size = 0;
    int leafSize = 0;
    //创建一个二叉树
    public Node bulidBinaryTree(){
        Node node1 = new Node('A');
        Node node2 = new Node('B');
        Node node3 = new Node('C');
        Node node4 = new Node('D');
        Node node5 = new Node('E');
        Node node6 = new Node('F');
        Node node7 = new Node('G');
        Node node8 = new Node('H');
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.right = node8;
        return node1;
    }

    //前序遍历
    public void preOrderTraversal(Node root){
        //树不为空
        if(root != null){
            //根
            System.out.print(root.val);
            //左子树
            preOrderTraversal(root.left);
            //右子树
            preOrderTraversal(root.right);
        }
    }

    //中序遍历
    public void inOrderTraversal(Node root){
        if(root != null){
            //左子树
            inOrderTraversal(root.left);
            //根
            System.out.print(root.val);
            //右子树
            inOrderTraversal(root.right);
        }
    }

    //后序遍历
    public void postOrderTraversal(Node root){
        if(root != null){
            //左子树
            postOrderTraversal(root.left);
            //右子树
            postOrderTraversal(root.right);
            //根
            System.out.print(root.val);
        }
    }

    //求结点个数
    public void getSize1(Node root){
        //前序遍历
        if(root != null){
            size++;
            getSize1(root.left);
            getSize1(root.right);
        }
        /*
        //中序遍历
        if(root != null){
            getSize1(root.left);
            size++;
            getSize1(root.right);
        }
        //后序遍历
        if(root != null){
            getSize1(root.left);
            getSize1(root.right);
            size++;
        }
        */
    }
    //求节点个数
    public int getSize2(Node root){
        //如果没有结点
        if(root == null){
            return 0;
        }
        //只有一个根节点
        if(root.left == null && root.right == null){
            return 1;
        }
        return getSize2(root.left) + getSize2(root.right) + 1;
    }

    //求叶子结点个数
    public void getLeafSize1(Node root){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            leafSize++;
            return;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);
    }
    //求叶子结点个数
    public int getLeafSize2(Node root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return getLeafSize2(root.left) + getLeafSize2(root.right);
    }

    //求第k层结点个数
    public int getKLevelSize(Node root, int k){
        if(root == null){
            return 0;
        }
        if(k == 1){
            return 1;
        }
        return getKLevelSize(root.left, k - 1) + getKLevelSize(root.right, k - 1);
    }
    public static void main(String[] args) {
        MyBinaryTree binaryTree = new MyBinaryTree();
        Node root = binaryTree.bulidBinaryTree();

        System.out.print("前序遍历：");
        binaryTree.preOrderTraversal(root);
        System.out.println();
        System.out.print("中序遍历：");
        binaryTree.inOrderTraversal(root);
        System.out.println();
        System.out.print("后续遍历：");
        binaryTree.postOrderTraversal(root);
        System.out.println();

        System.out.println("结点个数：");
        binaryTree.getSize1(root);
        System.out.println(binaryTree.size);
        System.out.println(binaryTree.getSize2(root));

        System.out.println("叶子结点个数：");
        binaryTree.getLeafSize1(root);
        System.out.println(binaryTree.leafSize);
        System.out.println(binaryTree.getLeafSize2(root));
    }
}
