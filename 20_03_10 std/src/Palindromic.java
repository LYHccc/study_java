//输出所有的四位回文数

public class Palindromic {
    public static boolean isPalindromic(int n){
        int frist = n;
        int temp = 0;
        int num = 0;
        while(n > 0){
            temp = n % 10;
            num = num * 10 + temp;
            n /= 10;
        }
        return frist == num;
    }

    public static void main(String[] args) {
        for(int i = 1000; i < 10000; i++){
            if(isPalindromic(i)){
                System.out.println(i);
            }
        }
    }
}
