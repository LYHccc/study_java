//给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等
public class Solution {
    public boolean hasAlternatingBits(int n) {
        int m = n;
        int bit = 0;
        boolean first = true;
        while(m != 0){
            if(first){
                bit = m & 1;
                first = false;
            }else{
                if((m & 1) == bit){
                    return false;
                }
                bit = m & 1;
            }
            m = m >> 1;
        }
        return true;
    }
}
