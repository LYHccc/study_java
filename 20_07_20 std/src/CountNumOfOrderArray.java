/*数字在排序数组中出现的次数
题目描述：
统计一个数字在排序数组中出现的次数。
 */
public class CountNumOfOrderArray {
    /*
    //方法一：依次遍历数组找到k的个数
    public int GetNumberOfK(int [] array , int k) {
        int count = 0;
        for(int a : array){
            if(a == k)
                count++;
            if(count != 0 && a != k)
                break;
        }
        return count;
    }
    */

    //方法二：二分查找找到第一个k和最后一个k的位置，相减
    private static int getFirstK(int [] array , int k){
        int left = 0;
        int right = array.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(array[mid] > k){
                right = mid - 1;
            }else if(array[mid] < k){
                left = mid + 1;
            }else{
                if(mid - 1 >= 0 && array[mid - 1] == k){
                    right = mid - 1;
                }else{
                    return mid;
                }
            }
        }
        return  -1;
    }
    private static int getLastK(int [] array , int k){
        int left = 0;
        int right = array.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(array[mid] > k){
                right = mid - 1;
            }else if(array[mid] < k){
                left = mid + 1;
            }else{
                if(mid + 1 < array.length && array[mid + 1] == k){
                    left = mid + 1;
                }else{
                    return mid;
                }
            }
        }
        return  -1;
    }

    public static int GetNumberOfK(int [] array , int k) {
        int right = getLastK(array, k);
        int left = getFirstK(array, k);
        if(right == -1) return 0;
        return right - left + 1;
    }
}
