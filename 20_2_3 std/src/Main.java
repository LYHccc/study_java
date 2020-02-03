//编一个程序，读入用户输入的一串先序遍历字符串，根据此字符串建立一个二叉树（以指针方式存储）。
// 例如如下的先序遍历字符串： ABC##DE#G##F### 其中“#”表示的是空格，空格字符代表空树。
// 建立起此二叉树以后，再对二叉树进行中序遍历，输出遍历结果。

import java.util.Scanner;
class Node{
    char val;
    Node left;
    Node right;
    public Node(char val){
        this.val = val;
    }
}

public class Main{
    static int i = 0;
    public static Node buildTree(String s){
        if(s.charAt(i) != '#'){
            Node root = new Node(s.charAt(i));
            i++;
            root.left = buildTree(s);
            i++;
            root.right = buildTree(s);
            return root;
        }
        return null;
    }

    public static void inOrder(Node root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }

    public static void main(String[] args){
        i = 0;
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Node root = buildTree(line);
        inOrder(root);
        System.out.println();
    }
}