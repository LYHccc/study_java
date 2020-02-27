//优先级队列入队、出队、获取队首元素、判空操作的实现
import java.util.Arrays;
import java.util.PriorityQueue;

public class MyPriorityQueue {
    private int[] arr = new int[10];
    private int size = 0;

    public void shiftUpBig(int[] arr, int child){//大根堆向上调整
        int parent = (child - 1) / 2;
        while(child > 0) {
            if (arr[child] > arr[parent]) {
                ShiftDown.swap(arr, child, parent);
                child = parent;
                parent = (child - 1) / 2;
            } else {
                break;
            }
        }
    }

    public void shiftUpSmall(int[] arr, int child){//小根堆向上调整
        int parent = (child - 1) / 2;
        while(child > 0) {
            if (arr[child] < arr[parent]) {
                ShiftDown.swap(arr, child, parent);
                child = parent;
                parent = (child - 1) / 2;
            } else {
                break;
            }
        }
    }

    public void offer(int value){//入队
        if(size == arr.length){//扩容
            Arrays.copyOf(arr, arr.length * 2);
        }
        arr[size++] = value;//尾插
        shiftUpSmall(arr, size - 1);//向上调整
    }

    public int poll(){//出队
        if(size > 0){//如果队中有元素
            int poll = arr[0];//记录队首元素
            ShiftDown.swap(arr, 0, size - 1);//交换队首与队尾元素
            size--;//删除队尾元素
            ShiftDown.shiftDownSmall(arr, size, 0);//将队首元素调整下去
            return poll;//返回记录的队首元素
        }
        return -1;
    }

    public int peek(){//获取队首元素
        if(size > 0){
            return arr[0];//返回队首元素
        }
        return -1;
    }

    public boolean isEmpty(){//判断队列是否为空
        return size == 0;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(9);
        pq.offer(2);
        pq.offer(10);
        pq.offer(15);
        pq.offer(3);
        pq.offer(1);
        pq.offer(7);
        pq.offer(23);
        pq.offer(89);
        while(!pq.isEmpty()){
            System.out.print(pq.poll() + " ");
        }
        System.out.println();
        System.out.println("My PriorityQueue");
        MyPriorityQueue mpq = new MyPriorityQueue();
        mpq.offer(9);
        mpq.offer(2);
        mpq.offer(10);
        mpq.offer(15);
        mpq.offer(3);
        mpq.offer(1);
        mpq.offer(7);
        mpq.offer(23);
        mpq.offer(89);
        while(!mpq.isEmpty()){
            System.out.print(mpq.poll() + " ");
        }
        System.out.println();
    }
}
