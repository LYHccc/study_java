//股票价格跨度
//编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
//今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
//例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。
import java.util.Stack;

public class StockSpanner {
    Stack<Integer> priceStack = new Stack<>();
    Stack<Integer> numStack = new Stack<>();
    public StockSpanner() {

    }

    public int next(int price) {
        int num = 1;
        while(!priceStack.empty() && priceStack.peek() <= price){
            priceStack.pop();
            num += numStack.pop();
        }
        priceStack.push(price);
        numStack.push(num);
        return numStack.peek();
    }

    public static void main(String[] args) {
        StockSpanner s = new StockSpanner();
        System.out.println(s.next(32));
        System.out.println(s.next(82));
        System.out.println(s.next(73));
        System.out.println(s.next(99));
        System.out.println(s.next(91));
    }
}
