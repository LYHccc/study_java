//给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
//你可以返回满足此条件的任何数组作为答案。

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int[] a = new int[A.length];
        int left = 0;
        int right = A.length - 1;
        int index = 0;
        while(index != A.length){
            if(A[index] % 2 == 0){
                a[left++] = A[index];
            }else{
                a[right--] = A[index];
            }
            index++;
        }
        return a;
    }
}
