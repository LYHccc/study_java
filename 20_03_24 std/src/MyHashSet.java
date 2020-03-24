/*
不使用任何内建的哈希表库设计一个哈希集合
具体地说，你的设计应该包含以下的功能
add(value)：向哈希集合中插入一个值。
contains(value) ：返回哈希集合中是否存在这个值。
remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 */
class setNode{
    setNode next;
    int key;
    public setNode(int key){
        this.key = key;
        next = null;
    }
}
public class MyHashSet {
    private setNode[] arr = new setNode[10000];
    /** Initialize your data structure here. */
    public MyHashSet() {

    }

    public void add(int key) {
        int index = key % arr.length;
        setNode cur = arr[index];
        while(cur != null){
            if(cur.key == key){
                return;
            }
            cur = cur.next;
        }
        setNode node = new setNode(key);
        node.next = arr[index];
        arr[index] = node;
    }

    public void remove(int key) {
        int index = key % arr.length;
        setNode cur = arr[index];
        setNode prev = null;
        while(cur != null){
            if(cur.key == key){
                if(prev == null){
                    arr[index] = cur.next;
                }else{
                    prev.next = cur.next;
                }
                return;
            }else{
                prev = cur;
                cur = cur.next;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = key % arr.length;
        setNode cur = arr[index];
        while(cur != null){
            if(cur.key == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
}

