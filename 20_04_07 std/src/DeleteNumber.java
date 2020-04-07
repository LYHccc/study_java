/*删数
题目描述：
有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数，到末尾时循环至开头继续进行，求最后一个被删掉的数的原始下标位置。以8个数(N=7)为例:｛0，1，2，3，4，5，6，7｝，0->1->2(删除)->3->4->5(删除)->6->7->0(删除),如此循环直到最后一个数被删除。

输入描述：
每组数据为一行一个整数n(小于等于1000)，为数组成员数,如果大于1000，则对a[999]进行计算。

输出描述：
一行输出最后一个被删掉的数的原始下标位置。
 */
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DeleteNumber {
    /*
    //方法一：走两步一删除
    private static int delete(List<Integer> list){
        int index = 0;
        while(list.size() != 1){
            for(int i = 0; i < 2; i++){
                index++;
                if(index == list.size()){
                    index = 0;
                }
                if(list.size() == 1){
                    return list.get(0);
                }
            }
            list.remove(index);
            if(index >= list.size()){
                index = 0;
            }
        }
        return list.get(0);
    }
    */

    //方法二：取余
    private static int delete(List<Integer> list){
        int index = 0;
        while(list.size() > 1){
            index = (index + 2) % list.size();
            list.remove(index);
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            List<Integer> list = new LinkedList<>();
            int n = scanner.nextInt();
            if(n > 1000){
                n = 1000;
            }
            for(int i = 0; i < n; i++){
                list.add(i);
            }
            System.out.println(delete(list));
        }
    }
}
