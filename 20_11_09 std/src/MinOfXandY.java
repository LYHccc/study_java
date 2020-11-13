/*
 * x+y的最小值
 * 2019^2, X^2, Y^2构成等差数列(2019<X<Y)，满足条件的X和Y可能有多种情况，请给出X+Y的值，并且令X+Y尽可能的小。
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
