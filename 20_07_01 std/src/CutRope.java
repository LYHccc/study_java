/*剪绳子
题目描述
给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），
每段绳子的长度记为k[1],...,k[m]。
请问k[1]x...xk[m]可能的最大乘积是多少？
例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class CutRope {
    /**
     * 问题类似于定周长求最大面积的问题（例如给定四边形周长，求最大面积），
     * 当k[0]==k[1]==,==k[m]时乘积最大，设k[0]=x，那么n=x*m,乘积可以用下式表示f(x)=(x)^(n/x)
     * f(x)=(x)^(n/x)图像在(0,e)递增(e,∞)递减
     * 所以分割出x = e(2.718)时，乘积最大，在(0,e)递增(e,∞)递减，3比2更接近e
     * 将绳子尽可能分割为3时，乘积最大
     * 当n % 3 == 0时，分割出n/3个3
     * 当n % 3 == 1时，2*2也就是4大于1 * 3因此取出一个三，分割出n/3 - 1个3，和一个4
     * 当n % 3 == 2时，分割出n/3个3和一个2
     * @param target
     * @return
     */
    public int cutRope(int target) {
        if(target == 2){
            return 1;
        }
        if(target == 3){
            return 2;
        }
        if(target % 3 == 0){
            return (int)Math.pow(3, target / 3);
        }else if(target % 3 == 1){
            return 4 * (int)Math.pow(3, target / 3 - 1);
        }else{
            return 2 * (int)Math.pow(3, target / 3);
        }
    }
}
