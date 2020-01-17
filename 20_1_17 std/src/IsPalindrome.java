//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

public class IsPalindrome {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int invertedOrder = 0;
        int num = x;
        int temp = 0;
        while(num != 0){
            temp = num % 10;
            invertedOrder = invertedOrder * 10 + temp;
            num /= 10;
        }
        return x == invertedOrder;
    }
}
