/*连续子数组的最大和
题目描述
HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:
在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class MaxSumOfcontinuousArray {
    /**
     * 方法一：f(i)：以i为结尾的连续子数组的最大和
     * f(i) = max(f(i - 1) + arr[i], arr[i])
     * max = max(max, f(i))
     * f(0) = arr[0] max = arr[0]
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int max = array[0];
        for(int i = 1; i < array.length; i++){
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /*
    //方法二：f(i)以i为结尾的连续子数组的最大和
    //如果当前的连续最大和sum对我f(i)增大有用的话(即sum大于0)就加sum，否则就是我当前位置
    public int FindGreatestSumOfSubArray(int[] array) {
        int max = array[0];
        int sum = array[0];
        for(int i = 1; i < array.length; i++){
            if(sum > 0){
                sum += array[i];
            }else{
                sum = array[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
     */

}
