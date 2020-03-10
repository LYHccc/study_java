//利用字母可以组成一些美丽的图形，下面给出了一个例子：
//ABCDEFG
//BABCDEF
//CBABCDE
//DCBABCD
//EDCBABC
//这是一个5行7列的图形，请找出这个图形的规律，并输出一个n行m列的图形。
//输入一行，包含两个整数n和m，分别表示你要输出的图形的行数的列数。
//输出n行，每个m个字符，为你的图形。
import java.util.Scanner;

public class LettersGraphics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int line = scanner.nextInt();
        String[] s = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < line; i++){
            str.append(s[i]);
        }
        System.out.println(str.toString());
        for(int i = 1; i < row; i++){
            StringBuilder str1 = new StringBuilder();
            int start = i;
            for(int j = start; j >= 0; j--){
                if(start - j == line){
                    break;
                }
                str1.append(s[j]);
            }
            for(int k = 1; k < line - start; k++){
                str1.append(s[k]);
            }
            System.out.println(str1);
        }
    }
}
