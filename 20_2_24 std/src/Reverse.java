//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
//假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。

public class Reverse {
    //方法一：直接判断是否溢出
    public int reverse(int x) {
        int num = 0;
        while(x != 0){
            int temp = x % 10;
            x /= 10;
            if(num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && temp > 7))
                return 0;
            if(num < Integer.MIN_VALUE / 10 || (num == Integer.MIN_VALUE / 10 && temp > 8))
                return 0;
            num = num * 10 + temp;
        }
        return num;
    }

    /*
    //方法二：用long类型来判断是否产生溢出
    public int reverse(int x) {
        long num = 0;
        while(x != 0){
            int temp = x % 10;
            num = num * 10 + temp;
            x /= 10;
        }
        return (int)num == num ? (int)num : 0;
    }
    */
}
