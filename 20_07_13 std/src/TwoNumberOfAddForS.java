/*和为S的两个数字
题目描述
输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
如果有多对数字的和等于S，输出两个数的乘积最小的。
输出描述:
对应每个测试案例，输出两个数，小的先输出。
 */
import java.util.ArrayList;

public class TwoNumberOfAddForS {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if(array.length == 0)
            return list;
        int left = 0, right = array.length - 1;
        while(left < right){
            if(array[left] + array[right] == sum){
                list.add(array[left]);
                list.add(array[right]);
                break;
            }else if(array[left] + array[right] > sum){
                right--;
            }else{
                left++;
            }
        }
        return list;
    }
}
