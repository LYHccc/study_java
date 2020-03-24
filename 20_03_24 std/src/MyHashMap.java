/*
不使用任何内建的哈希表库设计一个哈希映射
具体地说，你的设计应该包含以下的功能:
put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。
get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。
remove(key)：如果映射中存在这个键，删除这个数值对。
 */
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
public class MyHashMap {
    private Node[] arr = new Node[10000];
    /** Initialize your data structure here. */
    public MyHashMap() {

    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = key % arr.length;
        Node cur = arr[index];
        while(cur != null){
            if(cur.key == key){
                cur.value = value;
                return;
            }
            cur = cur.next;
        }
        Node node = new Node(key, value);
        node.next = arr[index];
        arr[index] = node;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = key % arr.length;
        Node cur = arr[index];
        while(cur != null){
            if(cur.key == key){
                return cur.value;
            }
            cur = cur.next;
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = key % arr.length;
        Node cur = arr[index];
        Node prev = null;
        while(cur != null){
            if(cur.key == key){
                if(prev == null){
                    arr[index] = cur.next;
                }else{
                    Node next = cur.next;
                    prev.next = next;
                    cur = next;
                }
                return;
            }else{
                prev = cur;
                cur = cur.next;
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        hashMap.get(1);
        hashMap.get(3);
        hashMap.put(2, 1);
        hashMap.get(2);
        hashMap.remove(2);
        hashMap.get(2);
    }
}
