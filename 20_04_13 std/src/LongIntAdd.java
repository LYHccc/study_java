/*超长正整数相加
题目描述:
请设计一个算法完成两个超长正整数的加法

输入描述:
输入两个字符串数字

输出描述:
输出相加后的结果，string型
 */
import java.util.Scanner;

public class LongIntAdd {
    public static String AddLomgImteger(String addend, String augend) {
        StringBuilder str = new StringBuilder();
        char[] add = addend.toCharArray();
        char[] aug = augend.toCharArray();
        int index1 = add.length - 1;
        int index2 = aug.length - 1;
        int carry = 0;
        while(index1 >= 0 && index2 >= 0){
            carry += (add[index1--] - '0') + (aug[index2--] - '0');
            str.append(carry % 10);
            carry /= 10;
        }

        while(index1 >= 0){
            carry += add[index1--] - '0';
            str.append(carry % 10);
            carry /= 10;
        }
        while(index2 >= 0){
            carry += aug[index2--] - '0';
            str.append(carry % 10);
            carry /= 10;
        }

        if(carry != 0){
            str.append(carry);
        }

        return str.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String addend = scanner.nextLine();
            String augend = scanner.nextLine();
            System.out.println(AddLomgImteger(addend, augend));
        }
    }
}
