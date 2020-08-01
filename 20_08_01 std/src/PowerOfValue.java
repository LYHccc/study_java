/*数值的整数次方
题目描述
给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
保证base和exponent不同时为0
 */
public class PowerOfValue {
    public double Power(double base, int exponent) {
        if(base == 0) return 0;
        double res = 1.0;
        if(exponent >= 0){
            for(int i = 0; i < exponent; i++){
                res *= base;
            }
        }else{
            for(int i = 0; i < Math.abs(exponent); i++){
                res *= base;
            }
            res = 1 / res;
        }
        return res;
    }
}
