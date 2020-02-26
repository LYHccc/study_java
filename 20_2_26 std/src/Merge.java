import java.util.Arrays;

public class Merge {
    //方法一：三指针，比较A的待排序数组的最后一个元素和B的待排序数组的最后一个元素大小
    public void merge(int[] A, int m, int[] B, int n) {
        int index = A.length - 1;
        int aIndex = m - 1;
        int bIndex = n - 1;
        while(aIndex >= 0 && bIndex >= 0){
            if(A[aIndex] > B[bIndex]){
                A[index--] = A[aIndex--];
            }else{
                A[index--] = B[bIndex--];
            }
        }
        //如果A排完了B没排完的话
        while(bIndex >= 0){
            A[index--] = B[bIndex--];
        }
    }
    /*
    //方法二：先合并再排序
    public void merge(int[] A, int m, int[] B, int n) {
        int index = 0;
        for(int i = 0; i < n; i++){
            A[m + i] = B[i];
        }
        Arrays.sort(A);
    }
    */
}
