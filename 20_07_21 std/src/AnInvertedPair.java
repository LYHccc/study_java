/*数组中的逆序对
题目描述
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
输入描述:
题目保证输入的数组中没有的相同的数字
数据范围：
	对于50%的数据,size<=10^4
	对于75%的数据,size<=10^5
	对于100%的数据,size<=2*10^5
 */
public class AnInvertedPair {
    /**
     * 利用归并排序的思路，在合并的时候进行逆序对的判断
     * 利用双指针指针一指向要合并的前边数组的末尾，指针二指向后边数组的末尾
     * 如果指针一的值大于指针二的值，那么逆序对个数增加后边数组的当前元素的个数(因为末尾是当前数组最大的)
     * 将大的值存入中间数组从后往前先存大的，再将指向大的值的指针前移一位
     */
    private static int count;

    private static void merge(int[] arr, int left, int mid, int right, int[] temp){
        int start1 = left, end1 = mid;
        int start2 = mid + 1, end2 = right;
        int index = right;
        while(start1 <= end1 && start2 <= end2){
            if(arr[end1] > arr[end2]){
                temp[index--] = arr[end1--];
                count += end2 - start2 + 1;
                count %= 1000000007;
            }else{
                temp[index--] = arr[end2--];
            }
        }
        while(start1 <= end1){
            temp[index--] = arr[end1--];
        }
        while(start2 <= end2){
            temp[index--] = arr[end2--];
        }
        for(int i = left; i <= right; i++){
            arr[i] = temp[i];
        }
    }

    private static void mergeSort(int[] arr, int left, int right, int[] temp){
        if(left >= right)
            return;
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid, temp);
        mergeSort(arr, mid + 1, right, temp);
        merge(arr, left, mid, right, temp);
    }

    public int InversePairs(int [] array) {
        int[] temp = new int[array.length];
        count = 0;
        mergeSort(array, 0, array.length - 1, temp);
        return count;
    }
}
