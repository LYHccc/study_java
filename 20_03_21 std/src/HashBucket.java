//开散列/哈希桶解决冲突实现哈希表的查找、插入、删除操作
class Node{
    Node next;
    int key;
    int value;
    public Node(int key, int value){
        this.key = key;
        this.value = value;
        next = null;
    }
}

public class HashBucket {
    private Node[] arr = new Node[10];
    private int size = 0;
    private static final double LOAD_FACTORY = 0.7;//负载因子最大值

    public double loadFactory(){//计算负载因子
        return size * 1.0 / arr.length;
    }

    public int get(int key){//查询
        int index = key % arr.length;//在哈希表中查找对应的下标
        Node cur = arr[index];//此下标处的头节点
        while(cur != null){//遍历此处链表
            if(cur.key == key){//找到返回对应的value
                return cur.value;
            }
            cur = cur.next;
        }
        return -1;//没找到返回-1
    }

    public void resize(){//扩容
        Node[] newArray = new Node[arr.length * 2];
        for(int i = 0; i < arr.length; i++){//遍历原数组，将原数组中的数据全部拷贝到新数组中
            Node cur = arr[i];//头节点
            while(cur != null){//遍历此下标处的链表
                Node next = cur.next;
                int index = cur.key % newArray.length;//新表中应该插入的位置
                cur.next = newArray[index];//进行头插
                newArray[index] = cur;
                cur = next;
            }
        }
        arr = newArray;
    }

    public int put(int key, int value){//插入
        if(loadFactory() >= LOAD_FACTORY){
            resize();
        }

        int index = key % arr.length;//计算哈希值
        Node cur = arr[index];//此处头节点
        while(cur != null){//遍历此处的链表，找到应该插入的位置
            if(cur.key == key){//不能插入相同的值
                int oldValue = cur.value;
                cur.value = value;
                return cur.value;
            }
            cur = cur.next;
        }
        //头插
        Node node = new Node(key, value);
        node.next = arr[index];
        arr[index] = node;
        size++;

        return -1;
    }

    public int remove(int key){//删除
        int index = key % arr.length;//计算哈希值
        Node cur = arr[index];//此处的头节点
        Node prev = null;
        while(cur != null){//遍历链表
            if(cur.key == key){//找到应该删除的节点
                if(prev == null){//头删
                    arr[index] = cur.next;
                }else{//非头删
                    prev.next = cur.next;
                }
                size--;
                return cur.value;
            }else{
                prev = cur;
                cur = cur.next;
            }
        }

        return -1;
    }

    public void printHashBuket(){//打印哈希表中的元素
        for(int i = 0; i < arr.length; i++){
            Node cur = arr[i];
            while(cur != null){
                System.out.print(cur.key + "-->" + cur.value + "  ");
                cur = cur.next;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        HashBucket hb = new HashBucket();
        hb.put(1,1);
        hb.put(2,2);
        hb.put(3,3);
        hb.put(4,4);
        hb.put(5,5);
        hb.put(6,6);
        hb.put(1, -1);
        hb.put(2, -2);
        hb.printHashBuket();

        System.out.println(hb.get(1));
        System.out.println(hb.get(6));
        System.out.println(hb.remove(5));
        hb.printHashBuket();
        System.out.println(hb.remove(3));
        hb.printHashBuket();
        System.out.println(hb.remove(100));
        hb.printHashBuket();
    }
}
