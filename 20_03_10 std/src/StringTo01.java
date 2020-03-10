//对于长度为5位的一个01串，每一位都可能是0或1，一共有32种可能。它们的前几个是：
//00000
//00001
//00010
//00011
//00100
//请按从小到大的顺序输出这32种01串。

public class StringTo01 {
    public static String BinToDec(int n){
        if(n == 0){
            return "00000";
        }
        int num = 0;
        int temp = 0;
        StringBuilder str = new StringBuilder();
        while(n > 0){
            temp = n % 2;
            str.insert(0, temp);
            n /= 2;
        }
        int len = str.length();
        for(int i = 0; i < 5 - len; i++){
            str.insert(0, "0");
        }
        return str.toString();
    }
    public static void main(String[] args) {
        for(int i = 0; i < 32; i++){
            System.out.println(BinToDec(i));
        }
    }
}
