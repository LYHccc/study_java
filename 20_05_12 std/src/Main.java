/*整数中1出现的次数（从1到n整数中1出现的次数）
 题目描述
求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
ACMer希望你们帮帮他,并把问题更加普遍化,
可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */

public class Main {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        int high = 0, now = 0, low = 0;

        for(int i = 1; i <= n; i *= 10){
            high = n / (i * 10);    //高位
            now = (n / i) % 10;     //当前位
            low = n % i;            //低位

            if(now < 1){
                //如果当前位小于1，出现1的次数仅由高位决定，等于高位数字 * 当前位数
                count += high * i;
            }else if(now > 1){
                //如果大于1，出现1的次数仅由高位决定，等于(高位数字 + 1) * 当前位数
                count += (high + 1) * i;
            }else{
                //如果等于1，出现1的次数由高位和低位共同决定，等于高位数字 * 当前位数 + (低位数字 + 1)
                count += high * i + low + 1;
            }
        }

        return count;
    }
}
