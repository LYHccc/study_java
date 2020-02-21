//如果一个由 '0' 和 '1' 组成的字符串，是以一些 '0'（可能没有 '0'）后面跟着一些 '1'（也可能没有 '1'）的形式组成的，那么该字符串是单调递增的。
//我们给出一个由字符 '0' 和 '1' 组成的字符串 S，我们可以将任何 '0' 翻转为 '1' 或者将 '1' 翻转为 '0'。
//返回使 S 单调递增的最小翻转次数。
//1 <= S.length <= 20000
//S 中只包含字符 '0' 和 '1'

public class MinFlipsMonoIncr {
    public int minFlipsMonoIncr(String S) {
        int length = S.length();
        int[] sum = new int[length + 1];//sum数组第n个位置用来记录前n个数的和(即有多少个1)
        for(int i = 0; i < length; i++){//sum数组初始化
            sum[i + 1] = sum[i] + S.charAt(i) - '0';//从第一个位置开始(因为第0个位置没有意义，不存在前0个之说)
        }
        int min = 20000;
        for(int i = 0; i <= length; i++){//依次枚举正确的结果前i个是0的情况
            //sum[i] + length - i - (sum[length] - sum[i])是要翻转的总数
            //sun[i]是前i个要翻转的1的个数
            //length - i - (sum[length] - sum[i]是从i向后0的个数(sum[length] - sum[i]从i向后有多少个1，length - i从i向后有多少个数字)
            min = Math.min(min, sum[i] + length - i - (sum[length] - sum[i]));
        }
        return min;
    }
}
