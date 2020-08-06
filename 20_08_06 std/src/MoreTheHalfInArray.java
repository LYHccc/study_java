/*数组中出现次数超过一半的数字
题目描述
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
import java.util.Arrays;
import java.util.HashMap;

public class MoreTheHalfInArray {
    /*
    //方法一：map统计个数
    public int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int a : array){
            map.put(a, map.getOrDefault(a, 0) + 1);
            if(map.get(a) > (array.length / 2)){
                return a;
            }
        }
        return 0;
    }
    */

    /*
    //方法二：排序，中间位置一定是超过一半的
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length == 0) return 0;
        Arrays.sort(array);
        int mid = array.length / 2;
        if(mid == 0) return array[0];
        for(int i = 0; i < mid; i++){
            if(array[i] == array[i + mid])
                return array[mid];
        }
        return 0;
    }
    */

    /**
     * 方法三 ：消除两个不同的，最后剩下的一定是超过一半的
     * 将剩下的元素去数组中统计个数是否超过一半
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length == 0) return 0;
        int target = array[0];
        int times = 1;
        for(int i = 1; i < array.length; i++){
            if(times == 0){
                target = array[i];
                times = 1;
            }else if(array[i] == target){
                times++;
            }else{
                times--;
            }
        }

        int count = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] == target)
                count++;
        }

        return count > array.length / 2 ? target : 0;
    }
}
