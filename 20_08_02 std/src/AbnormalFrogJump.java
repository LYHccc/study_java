/*变态青蛙跳台阶
题目描述
一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class AbnormalFrogJump {
    /**
     * 方法一：f(n)：跳上第n阶有多少种跳法
     * f(n) = f(n -1) + f(n - 2) + ...+f(n - n),f(n - 1) = f(n - 2) + f(n - 3) + ... + f(n - n)
     * 得到f(n) = f(n - 1) + f(n - 1) = 2 * f(n - 1)
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {
        int res = 1;
        for(int i = 2; i <= target; i++){
            res *= 2;
        }
        return res;
    }

    /*
    //方法二：运用移位运算 时间复杂度O（1）
    public int JumpFloorII(int target) {
        int res = 1;
        return res << (target - 1);
    }
    */
}
