/*旋转数组的最小数字
题目描述
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class MinOfRotateArray {
    /*
    //方法一：暴力法
    public int minNumberInRotateArray(int [] array) {
        int len = array.length;
        if(len == 0) return 0;
        int min = array[0];
        for(int i = 1; i < len; i++){
            if(array[i] < min){
                return array[i];
            }
        }

        return min;
    }
    */

    /**
     * 方法二：二叉查找思路找数组中最小的元素
     * mid中间位置，left左边，right右边
     * if(arr[mid] > arr[right])说明最小的元素肯定在mid右边
     * if(arr[mid] < arr[right])说明最小的元素就是mid或者在mid左边
     * if(arr[mid] == arr[right])就只能一步一步判断
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int [] array) {
        if(array.length == 0) return 0;
        int left = 0;
        int right = array.length - 1;
        while(left < right){
            int mid = (left + right) / 2;
            if(array[mid] > array[right]){
                left = mid + 1;
            }else if(array[mid] < array[right]){
                right = mid;
            }else{
                right--;
            }
        }

        return array[left];
    }
}
