//给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
import java.util.Arrays;

public class SortedSquares {
    public int[] sortedSquares(int[] A) {
        for(int i = 0; i < A.length; i++){
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }
}
