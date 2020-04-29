/*整数与IP地址间的转换
题目描述
原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，
然后把这个二进制数转变成一个长整数。
举例：一个ip地址为10.0.3.193
每段数字             相对应的二进制数
10                   00001010
0                    00000000
3                    00000011
193                  11000001
组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，
即该IP地址转换后的数字就是它了。
的每段可以看成是一个0-255的整数，需要对IP地址进行校验

输入描述:
输入
1 输入IP地址
2 输入10进制型的IP地址

输出描述:
输出
1 输出转换成10进制的IP地址
2 输出转换后的IP地址
 */
import java.util.Scanner;

public class IPTransformInteger {
    private static long ipTransformInteger(String s){
        String[] sArr = s.split("\\.");
        int len = sArr.length;
        long[] arr = new long[len];
        StringBuilder str = new StringBuilder();

        for(int i = 0; i < len; i++){
            arr[i] = Long.parseLong(sArr[i]);
            StringBuilder temp = new StringBuilder();
            temp.append(Long.toBinaryString(arr[i]));
            while(temp.length() < 8){
                temp.insert(0, "0");
            }
            str.append(temp);
        }

        long res = Long.parseLong(str.toString(), 2);
        return res;
    }

    private static String intTransformIp(String num){
        long n = Long.parseLong(num);
        StringBuilder str = new StringBuilder();
        str.append(Long.toBinaryString(n));
        while(str.length() < 32){
            str.insert(0, "0");
        }

        String[] sArr = new String[4];
        long[] arr = new long[4];
        StringBuilder res = new StringBuilder();

        for(int i = 0; i < 4; i++){
            sArr[i] = str.toString().substring(i * 8, (i + 1) * 8);
            arr[i] = Long.parseLong(sArr[i], 2);
            res.append(arr[i]).append(".");
        }
        res.deleteCharAt(res.length() - 1);

        return res.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String ip = scanner.next();
            String num = scanner.next();
            System.out.println(ipTransformInteger(ip));
            System.out.println(intTransformIp(num));
        }
    }
}