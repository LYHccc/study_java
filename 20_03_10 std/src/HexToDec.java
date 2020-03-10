//十六进制转十进制
//从键盘输入一个不超过8位的正的十六进制数字符串，将它转换为正的十进制数后输出。
import java.util.Scanner;

public class HexToDec {
    public static long hexToDec(String hex){
        int pow = 0;
        long num = 0;
        for(int i = hex.length() - 1; i >= 0; i--){
            char c = hex.charAt(i);
            int n = c - '0';
            switch (c){
                case 'A':
                    n = 10;
                    break;
                case 'B':
                    n = 11;
                    break;
                case 'C':
                    n = 12;
                    break;
                case 'D':
                    n = 13;
                    break;
                case 'E':
                    n = 14;
                    break;
                case 'F':
                    n = 15;
                    break;
            }
            num += n * Math.pow(16, pow);
            pow++;
        }
        return num;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String hex = scanner.nextLine();
        System.out.println(hexToDec(hex));
    }
}
