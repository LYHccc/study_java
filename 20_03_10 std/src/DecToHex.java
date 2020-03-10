//十进制转十六进制
//输入包含一个非负整数a，表示要转换的数。0<=a<=2147483647
//输出这个整数的16进制表示
import java.util.Scanner;

public class DecToHex {
    public static String decToHex(int n){
        if(n == 0){
            return "0";
        }
        StringBuilder s = new StringBuilder();
        while(n > 0){
            int temp = n % 16;
            StringBuilder str = new StringBuilder();
            switch (temp){
                case 10:
                    str.append("A");
                    break;
                case 11:
                    str.append("B");
                    break;
                case 12:
                    str.append("C");
                    break;
                case 13:
                    str.append("D");
                    break;
                case 14:
                    str.append("E");
                    break;
                case 15:
                    str.append("F");
                    break;
            }
            if(temp >= 10){
                s.insert(0, str);
            }else{
                s.insert(0, temp + "");
            }
            n /= 16;
        }
        return s.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(decToHex(n));
    }
}
