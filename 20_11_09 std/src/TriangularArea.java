/*
 *三角形面积
 *已知三角形三个顶点在直角坐标系下的坐标分别为：(2.3, 2.5),(6.4, 3.1),(5.1, 7.2)，求该三角形的面积。
 *注意，要提交的是一个小数形式表示的浮点数。
 *要求精确到小数后3位，如不足3位，需要补零。
 */
//海伦公式直接计算
public class TriangularArea {
	public static void main(String[] args){
		double a = Math.sqrt((6.4 - 2.3) * (6.4 - 2.3) + (3.1 - 2.5) * (3.1 - 2.5));
		double b = Math.sqrt((6.4 - 5.1) * (6.4 - 5.1) + (7.2 - 3.1) * (7.2 - 3.1)); 
		double c = Math.sqrt((5.1 - 2.3) * (5.1 - 2.3) + (7.2 - 2.5) * (7.2 - 2.5));
		double p = (a + b + c) / 2.0;
		System.out.println(p);
		double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
		System.out.println(s);
	}
}
