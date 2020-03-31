/*数组中的逆序对
有一组数，对于其中任意两个数组，若前面一个大于后面一个数字，则这两个数字组成一个逆序对。
请设计一个高效的算法，计算给定数组中的逆序对个数。
给定一个int数组A和它的大小n，请返回A中的逆序对个数。保证n小于等于5000。
 */
public class TheReverseOfArray {
    /*
    //方法一：暴力
    public int count(int[] A, int n) {
        int len = A.length;
        int count = 0;
        for(int i = 0; i < len - 1; i++){
            for(int j = i + 1; j < len; j++){
                if(A[i] > A[j])
                    count++;
            }
        }
        return count;
    }
    */

    //方法二：归并排序，累加逆序对
    public int count(int[] A, int n) {
        if(n == 0){
            return 0;
        }
        return countMergeSort(A, 0, n - 1);
    }

    //整个归并过程的所有逆序对数
    private int countMergeSort(int[] arr, int left, int right){
        //剩下一个元素将不再进行归并
        if(left >= right){
            return 0;
        }
        //中间位置
        int mid = (left + right) / 2;
        //左边的元素进行归并产生的逆序对数 加上 右边归并产生的逆序对数 加上 最后一次归并产生的逆序对数
        return countMergeSort(arr, left, mid) + countMergeSort(arr, mid + 1, right) + merge(arr, left, mid, right);
    }

    //一次合并过程中产生的逆序对数
    private int merge(int[] arr, int left, int mid, int right){
        int count = 0;
        int[] temp = new int[right - left + 1];
        int start1 = left, end1 = mid;
        int start2 = mid + 1, end2 = right;
        int index = 0;
        while(start1 <= end1 && start2 <= end2){
            if(arr[start1] <= arr[start2]){
                temp[index++] = arr[start1++];
            }else{
                temp[index++] = arr[start2++];
                count += mid - start1 + 1;
            }
        }
        while(start1 <= end1){
            temp[index++] = arr[start1++];
        }
        while(start2 <= end2){
            temp[index++] = arr[start2++];
        }
        for(int i = 0; i < temp.length; i++){
            arr[left++] = temp[i];
        }
        return count;
    }
}

