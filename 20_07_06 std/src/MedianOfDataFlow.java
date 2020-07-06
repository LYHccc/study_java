/*数据流中的中位数
题目描述:
如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOfDataFlow {
    //小根堆，存放较大的元素
    PriorityQueue<Integer> min = new PriorityQueue<>();
    //大根堆，存放较小的元素
    PriorityQueue<Integer> max = new PriorityQueue<>(new Comparator<Integer>(){
        @Override
        public int compare(Integer a, Integer b){
            return b - a;
        }
    });

    //当前已经插入了的元素个数
    int count = 0;
    public void Insert(Integer num) {
        //如果count是偶数，先向小根堆插入，再将小根堆的堆顶元素取出插入大根堆
        //如果count是奇数，先向大根堆插入，再将大根堆的堆顶元素取出插入小根堆
        if(count % 2 == 0){
            min.offer(num);
            max.offer(min.poll());
        } else{
            max.offer(num);
            min.offer(max.poll());
        }
        count++;
    }

    public Double GetMedian() {
        //如果count是偶数，中位数就是大根堆和小根堆的堆顶的平均值
        //如果count是奇数，中位数就是大根堆的堆顶
        if(count % 2 == 0){
            return new Double((min.peek() + max.peek()) * 1.0 / 2);
        }else{
            return new Double(max.peek());
        }
    }
}
