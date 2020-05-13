/*2的个数
题目描述
请编写一个方法，输出0到n(包括n)中数字2出现了几次。
给定一个正整数n，请返回0到n的数字中2出现了几次。
 */
public class CountTo2 {
    /*
    设N = abcde ,其中abcde分别为十进制中各位上的数字。
    例如如果要计算百位上2出现的次数，它要受到3方面的影响：百位上的数字，百位以下（低位）的数字，百位以上（高位）的数字。
    ① 如果百位上数字小于2，百位上可能出现2的次数由更高位决定。比如：12013，
    则可以知道百位出现2的情况可能是：200~299，1200~1299,2200~2299，，...，11200~11299，一共1200个。
    可以看出是由更高位数字（12）决定，并且等于更高位数字（12）乘以 当前位数（100）。

    ② 如果百位上数字为2，百位上可能出现2的次数不仅受更高位影响还受低位影响。比如：12213，
    则可以知道百位受高位影响出现的情况是：200~299，1200~1299,2200~2299，，....，11200~11299，一共1200个。
    和上面情况一样，并且等于更高位数字（12）乘以 当前位数（100）。
    但同时它还受低位影响，百位出现1的情况是：12200~12213,一共114个，等于低位数字（113）+1。

    ③ 如果百位上数字大于2（3~9），则百位上出现1的情况仅由更高位决定，比如12313，
    则百位出现1的情况是：300~399,1300~1399，2300~2399，...，11300~11399,12300~12399,一共有1300个，
    并且等于更高位数字+1（12+1）乘以当前位数（100）。
     */
    public int countNumberOf2s(int n) {
        int count = 0;
        int high = 0, now = 0, low = 0;

        for(int i = 1; i <= n; i *= 10){
            high = n / (i * 10);    //高位
            now = (n / i) % 10;     //当前位
            low = n % i;            //低位

            if(now < 2){
                //如果当前位小于2，出现2的次数仅由高位决定，等于高位数字 * 当前位数
                count += high * i;
            }else if(now > 2){
                //如果大于2，出现2的次数仅由高位决定，等于(高位数字 + 1) * 当前位数
                count += (high + 1) * i;
            }else{
                //如果等于2，出现2的次数由高位和低位共同决定，等于高位数字 * 当前位数 + (低位数字 + 1)
                count += high * i + low + 1;
            }
        }

        return count;
    }
}