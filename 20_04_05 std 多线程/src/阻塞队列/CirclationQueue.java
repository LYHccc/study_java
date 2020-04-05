package 阻塞队列;

public class CirclationQueue {
    private static final int CAPACITY = 5;
    private int[] queue = new int[CAPACITY];
    private int front = 0;
    private int rear = 0;
    private int size = 0;

    public synchronized void put(int value) throws InterruptedException {
        //队列已满
        while(size == queue.length){
            //生产者阻塞，等待消费者唤醒
            wait();
        }

        //队列没满
        queue[rear] = value;
        rear++;
        if(rear == queue.length){
            rear = 0;
        }
        size++;
        //System.out.println(size);
        //生产者试图唤醒阻塞的消费者和生产者
        notifyAll();
    }

    public synchronized int take() throws InterruptedException {
        //队列为空
        while(size == 0){
            //消费者阻塞，等待生产者唤醒
            wait();
        }

        //队列不为空
        int value = queue[front];
        front++;
        if(front == queue.length){
            front =0;
        }
        size--;
        //System.out.println(size);
        //消费者试图唤醒阻塞的消费者和生产者
        notifyAll();
        return value;
    }
}
