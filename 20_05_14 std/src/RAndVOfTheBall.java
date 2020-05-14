/*球的半径和体积
题目描述：
输入球的中心点和球上某一点的坐标，计算球的半径和体积

输入描述:
球的中心点和球上某一点的坐标，以如下形式输入：x0 y0 z0 x1 y1 z1

输出描述:
输入可能有多组，对于每组输入，输出球的半径和体积，并且结果保留三位小数
为避免精度问题，PI值请使用arccos(-1)。
 */
import java.util.Scanner;

public class RAndVOfTheBall {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            int x0 = scanner.nextInt();
            int y0 = scanner.nextInt();
            int z0 = scanner.nextInt();
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int z1 = scanner.nextInt();
            double temp = Math.sqrt((x0 - x1) * (x0- x1) + (y0 - y1) * (y0 - y1));
            double r = Math.sqrt(temp * temp + (z0 - z1) * (z0 - z1));
            double v = (4.0 / 3.0) * Math.PI * r * r * r;
            System.out.println(String.format("%.3f", r) + " " + String.format("%.3f", v));
        }
    }
}
