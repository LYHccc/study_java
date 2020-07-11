/*不用加减乘除做加法
题目描述：
写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class Add {
    public int Add(int num1,int num2) {
        if(num2 != 0){
            int num = num1 ^ num2;
            int carry = (num1 & num2) << 1;
            return Add(num, carry);
        }
        return num1;
    }
}
