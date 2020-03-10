//153 = 1 * 1 * 1 + 5 * 5 * 5 + 3 * 3 * 3;
//输出所有这样的三位数
public class SpecialNumber {
    public static boolean isSoecial(int n){
        int value = n;
        int sum = 0;
        int temp = 0;
        while(n > 0){
            temp = n % 10;
            sum += temp * temp * temp;
            n /= 10;
        }
        return value == sum;
    }
    public static void main(String[] args) {
        for(int i = 100; i < 1000; i++){
            if(isSoecial(i)){
                System.out.println(i);
            }
        }
    }
}
