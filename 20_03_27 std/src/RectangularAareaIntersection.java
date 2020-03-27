/*矩形面积交
问题描述:
　　平面上有两个矩形，它们的边平行于直角坐标系的X轴或Y轴。对于每个矩形，我们给出它的一对相对顶点的坐标，请你编程算出两个矩形的交的面积。
输入格式;
　　输入仅包含两行，每行描述一个矩形。
　　在每行中，给出矩形的一对相对顶点的坐标，每个点的坐标都用两个绝对值不超过10^7的实数表示。
输出格式;
　　输出仅包含一个实数，为交的面积，保留到小数后两位。
 */
import java.util.Scanner;

public class RectangularAareaIntersection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] x = new double[4];
        double[] y = new double[4];
        double[] z = new double[4];
        for(int i = 0; i < 4; i++){
            x[i] = scanner.nextDouble();
            y[i] = scanner.nextDouble();
        }
        z[0] = Math.max(Math.min(x[0], x[1]), Math.min(x[2], x[3]));
        z[1] = Math.min(Math.max(x[0], x[1]), Math.max(x[2], x[3]));
        z[2] = Math.max(Math.min(y[0], y[1]), Math.min(y[2], y[3]));
        z[3] = Math.min(Math.max(y[0], y[1]), Math.max(y[2], y[3]));
        if(z[0] < z[1] && z[2] < z[3]){
            System.out.printf("%.2f\n", (z[1] - z[0]) * (z[3] - z[2]));
        }else{
            System.out.println("0.00");
        }
    }
}
