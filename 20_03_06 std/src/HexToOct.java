//给定n个十六进制正整数，输出它们对应的八进制数。
//输入格式:
//输入的第一行为一个正整数n （1<=n<=10）。
//接下来n行，每行一个由0~9、大写字母A~F组成的字符串，表示要转换的十六进制正整数，每个十六进制数长度不超过100000。
//输出格式:
//输出n行，每行为输入对应的八进制正整数。
//注意:
//输入的十六进制数不会有前导0，比如012A。
//输出的八进制数也不能有前导0。
import java.util.Arrays;
import java.util.Scanner;

public class HexToOct {
    /*
    //方法一：运用java包中自带的转换方法
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] s = new String[n];
        for(int i = 0; i < n; i++){
            s[i] = scanner.next();
        }
        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(s[i], 16);//将字符串s[i]按照十六进制解析成十进制整数
            String str = Integer.toString(a, 8);//将十进制整数解析成八进制字符串返回
            System.out.println(str);
        }
    }
    */

    //方法二：
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] s = new String[n];
        for(int i = 0; i < n; i++){
            s[i] = scanner.next();
        }
        //十六进制表和二进制表下标相同的位置对应的值相等
        //十六进制表
        String[] HEX = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        //二进制表
        String[] BIN = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};
        //八进制表
        String[] OCT = {"0", "1", "2", "3", "4", "5", "6", "7"};

        //遍历输入的所有字符串，将每个十六进制字符串先转化成二进制字符串，再由二进制字符串转化成八进制字符串
        for(int i = 0; i < n; i++){
            StringBuilder Bin = new StringBuilder();//二进制字符串
            StringBuilder Oct = new StringBuilder();//八进制字符串

            //将十六进制字符串转化为二进制字符串
            for(int j = 0; j < s[i].length(); j++){
                String s1 = Character.toString(s[i].charAt(j));//取出十六进制字符串当前位置的值
                int index = Arrays.binarySearch(HEX, s1);//判断这个值对应的十六进制表下标
                Bin.append(BIN[index]);//找到该下标处的二进制值加入二进制字符串中
            }

            //将二进制字符串前添加几个"0"，使其长度刚好为3的倍数(因为一位八进制刚好对应三位二进制)
            while(Bin.length() % 3 != 0){
                Bin.insert(0, "0");
            }

            int octLen = Bin.length() / 3;//八进制字符串的长度
            //将二进制字符串转化为八进制字符串
            for(int j = 0; j < octLen; j++){
                String oc = Bin.substring(3 * j, 3 * (j + 1));//将二进制字符串三位一取出
                int index = Arrays.binarySearch(BIN, "0" + oc);//在取出的值前边加一个"0"，在二进制表中判断这个值对应的八进制表下标
                Oct.append(OCT[index]);//找到该下标处的八进制值加入八进制字符串中
            }

            //删除八进制字符串前边没用的"0"
            while(Oct.charAt(0) == '0'){
                Oct.deleteCharAt(0);
            }

            System.out.println(Oct.toString());
        }
    }
}