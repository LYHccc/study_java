/*二进制中1的个数
题目描述
输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 */
public class TheNumberOf {
    public int NumberOf1(int n) {
        int count = 0;
        int temp = 1;
        while(temp != 0){
            if((n & temp) != 0){
                count++;
            }
            temp = temp << 1;
        }
        return count;
    }
}
