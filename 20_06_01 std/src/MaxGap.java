/*左右最值最大差
题目描述
给定一个长度为N(N>1)的整型数组A，可以将A划分成左右两个部分，左部分A[0..K]，右部分A[K+1..N-1]，
K可以取值的范围是[0,N-2]。求这么多划分方案中，左部分中的最大值减去右部分最大值的绝对值，最大是多少？
给定整数数组A和数组的大小n，请返回题目所求的答案。
 */
public class MaxGap {
    public int findMaxGap(int[] A, int n) {
        int max = 0;

        for(int k = 0; k <= n - 2; k++){
            int max1 = A[0];
            int max2 = A[k + 1];

            for(int i = 0; i <= k; i++){
                max1 = Math.max(max1, A[i]);
            }
            for(int i = k + 1; i <= n - 1; i++){
                max2 = Math.max(max2, A[i]);
            }
            int sub = Math.abs(max1 - max2);
            max = Math.max(max, sub);
        }

        return max;
    }
}
