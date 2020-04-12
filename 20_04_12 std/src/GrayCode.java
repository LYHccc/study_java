/*生成格雷码
题目描述:
在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同， 则称这种编码为格雷码(Gray Code)，
请编写一个函数，使用递归的方法生成N位的格雷码。
给定一个整数n，请返回n位的格雷码，顺序为从0开始。

测试样例：
1
返回：["0","1"]
 */
import java.util.Arrays;
import java.util.Scanner;

public class GrayCode {
    public static String[] getGray(int n) {
        if(n == 1){
            return new String[]{"0", "1"};
        }

        int len = (int)Math.pow(2, n);
        String[] sArr = new String[len];
        String[] temp = getGray(n - 1);
        int index = 0;
        for(int i = 0; i < len / 2; i++){
            StringBuilder str = new StringBuilder();
            str.append(temp[i]);
            str.insert(0, "0");
            sArr[index++] = str.toString();
        }

        for(int i = len / 2 - 1; i >= 0; i--){
            StringBuilder str = new StringBuilder();
            str.append(temp[i]);
            str.insert(0, "1");
            sArr[index++] = str.toString();
        }

        return sArr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(Arrays.toString(getGray(n)));
    }
}
