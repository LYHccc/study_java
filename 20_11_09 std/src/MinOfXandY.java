/*
 * x+y����Сֵ
 * 2019^2, X^2, Y^2���ɵȲ�����(2019<X<Y)������������X��Y�����ж�������������X+Y��ֵ��������X+Y�����ܵ�С��
 */
public class MinOfXandY {
	public static void main(String[] args){
		int source = 2019 * 2019;
		int x = 2020;
		while(true){
			int numX = x * x;//x^2
			int numY = x * x + x * x - source;//y^2
			int y = (int)Math.sqrt(numY);
			if(y * y == numY){
				System.out.println(x + y);
				break;
			}
			x++;
		}
	}
}
