//泛型存放<K, V>数据的二叉搜索树，实现put()、remove()、get()方法
class MyEntry<K, V>{
    K key;
    V value;
    MyEntry<K, V> left;
    MyEntry<K, V> right;
    public MyEntry(K key, V value){
        this.key = key;
        this.value = value;
        left = right = null;
    }
}
public class BSTree<K extends Comparable<K>, V> {
    private MyEntry<K, V> root = null;
    private int size = 0;

    public V put(K key, V value){
        if(root == null){
            root = new MyEntry<>(key, value);
            size++;
        }

        MyEntry<K, V> cur = root;
        MyEntry<K, V> parent = null;

        while(cur != null){
            parent = cur;
            int compare = cur.key.compareTo(key);
            if(compare == 0){
                V oldVal = cur.value;
                cur.value = value;
                return oldVal;
            }else if(compare > 0 ){
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }

        cur = new MyEntry<>(key, value);
        int compare = parent.key.compareTo(key);
        if(compare > 0){
            parent.left = cur;
        }else{
            parent.right = cur;
        }
        size++;
        return null;
    }

    public V remove(K key){
        if(root == null){
            return null;
        }

        MyEntry<K, V> cur = root;
        MyEntry<K, V> parent = null;

        while(cur != null){
            int compare = cur.key.compareTo(key);
            if(compare == 0){
                break;
            }else if(compare > 0){
                parent =cur;
                cur = cur.left;
            }else{
                parent = cur;
                cur = cur.right;
            }
        }

        if(cur == null){
            return null;
        }
        V oldval = cur.value;
        removeKey(parent, cur);
        return oldval;
    }

    public void removeKey(MyEntry<K, V> parent, MyEntry<K, V> cur){
        if(cur.left == null){
            if(cur != root){
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
        }else{
            parent = cur;
            MyEntry<K, V> next = cur.left;
            while(next.right != null){
                parent = next;
                next = next.right;
            }

            cur.key = next.key;
            cur.value = next.value;
            if(parent.left == next){
                parent.left = next.left;
            }else{
                parent.right = next.left;
            }
        }
    }

    public V get(K key){
        if(root == null){
            return null;
        }

        MyEntry<K, V> cur = root;

        while(cur != null){
            int compare = cur.key.compareTo(key);
            if(compare == 0){
                return cur.value;
            }else if(compare > 0){
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }

        return null;
    }

    public void inOrder(){
        inOrderTraveral(root);
        System.out.println();
    }
    public void inOrderTraveral(MyEntry<K, V> root){
        if(root != null){
            inOrderTraveral(root.left);
            System.out.print(root.key + "-->" + root.value + " ");
            inOrderTraveral(root.right);
        }
    }

    public static void main(String[] args) {
        /*
        BSTree<String, String> bst = new BSTree<>();
        bst.put("2号", "0002");
        bst.put("1号", "0001");
        bst.put("3号", "0003");
        bst.put("4号", "0004");
        bst.put("3号", "0006");
        bst.inOrder();
        */

        BSTree<Integer, Integer>  bst = new BSTree<>();
        bst.put(7, 7);
        bst.put(8, 8);
        bst.put(3, 3);
        bst.put(4, 4);
        bst.put(1, 1);
        bst.put(2, 2);
        bst.put(5, 5);
        bst.put(6, 6);
        bst.inOrder();
        Integer ret = bst.remove(10);
        System.out.println(ret);
        bst.inOrder();
        ret = bst.remove(5);
        System.out.println(ret);
        bst.inOrder();
        ret = bst.remove(5);
        System.out.println(ret);
        bst.inOrder();
        ret = bst.remove(7);
        System.out.println(ret);
        bst.inOrder();
    }
}
