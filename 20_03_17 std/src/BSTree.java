class Node{
    int val;
    Node left;
    Node right;
    public Node(int val){
        this.val = val;
        left = right = null;
    }
}
public class BSTree {
    private Node root = null;
    //在搜索书中查找val，找到返回val所在的节点，没找到的话返回null
    public Node find(int val){
        if(root == null)
            return null;
        Node cur = root;
        while(cur != null){
            //找到返回节点，如果当前节点值大于val，向搜索树左边遍历，反之向右遍历
            if(cur.val == val){
                return cur;
            }else if(cur.val > val){
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }
        return null;
    }

    //向二叉搜索书中插入节点，插入成功返回true，失败返回false
    public boolean insert(int val){
        if(root == null){
            root = new Node(val);
            return true;
        }
        Node cur = root;
        Node parent = null;
        //搜索适合插入的位置(都是叶子节点的位置)
        while(cur != null){
            parent = cur;
            //不能有值相等的节点
            if(cur.val == val){
                return false;
            }else if(cur.val > val){
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }
        //如果parent的值大于val插入parent左边，反之插入右边
        Node node = new Node(val);
        if(parent.val > val){
            parent.left = node;
        }else{
            parent.right = node;
        }
        return true;
    }

    //找到节点删除此节点
    public boolean remove(int val){
        if(root == null){
            return false;
        }
        Node cur = root;
        //cur的后继节点，保存cur的父节点的位置
        Node parent = null;
        //找到节点在搜索树中的位置
        while(cur != null){
            if(cur.val == val){
                break;
            }else if(cur.val > val){
                parent = cur;
                cur = cur.left;
            }else{
                parent = cur;
                cur = cur.right;
            }
        }
        //判断节点是否存在
        if(cur == null){
            return false;
        }
        //将此节点从搜索树中删除
        removeNode(parent, cur);
        return true;
    }
    //删除的过程
    public void removeNode(Node parent, Node cur){
        //1.cur左子树为空(包括cur为叶子节点，此时cur.right为null而已)
        //2.cur右子树为空
        //3.cur左右子数均不为空
        if(cur.left == null){
            if(cur != root){
                //cur的子树应该连接在父节点的方向
                if(parent.left == cur){
                    parent.left = cur.right;
                }else{
                    parent.right = cur.right;
                }
            }else{
                root = cur.right;
            }
        }else if(cur.right == null){
            if(cur != root){
                if(parent.left == cur){
                    parent.left = cur.left;
                }else{
                    parent.right = cur.left;
                }
            }else{
                root = cur.left;
            }
        }else{//cur左右均不为空
            parent = cur;
            Node next = cur.left;
            //找到左子树的最右节点
            while(next.right != null){
                parent = next;
                next = next.right;
            }
            //将左子树的最右节点的值赋给cur
            cur.val = next.val;
            //删除左子树最右节点
            if(parent.left == next){
                parent.left = next.left;
            }else{
                parent.right = next.left;
            }
        }
    }


    public void inOrderTraver(Node node){
        if(node != null){
            inOrderTraver(node.left);
            System.out.println(node.val + " ");
            inOrderTraver(node.right);
        }
    }
    public void inOrder(){
        inOrderTraver(root);
        System.out.println();
    }

    public static void main(String[] args) {
        BSTree bst = new BSTree();
        bst.insert(10);
        bst.insert(1);
        bst.insert(0);
        bst.insert(15);
        bst.insert(2);
        bst.insert(4);
        bst.insert(7);
        bst.inOrder();

        bst.remove(7);
        bst.inOrder();

        bst.remove(2);
        bst.inOrder();

        bst.remove(10);
        bst.inOrder();
    }
}