/*另类加法
请编写一个函数，将两个数字相加。不得使用+或其他算数运算符。
给定两个int A和B。请返回A＋B的值

测试样例：
1,2
返回：3
 */
import java.util.Scanner;

public class DifferentAdd {
    /*基本思路：运用位运算，我们可以观察到：
    位的异或运算跟求'和'的结果一致：
    异或 1^1=0 1^0=1 0^0=0
    求和 1+1=0 1+0=1 0+0=0
    位的与运算跟求'进位‘的结果一致：
    位与 1&1=1 1&0=0 0&0=0
    进位 1+1=1 1+0=0 0+0=0
    这样我们就可以求出每一位相加的结果和这一位所分别产生的进位，再将每一位产生的结果和下一位产生的进位相加就得到结果
    */
    private static int addAB(int A, int B) {
        if(B != 0) {
            int num = A ^ B;//每一位的和(不包括下一位进位)
            int carry = (A & B) << 1;//每一位的进位，将其左移一位，就可以将此进位移到该加到的位置
            return addAB(num, carry);//加上进位
        }
        return A;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(addAB(a, b));
    }
}
