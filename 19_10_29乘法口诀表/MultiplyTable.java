//输出乘法口诀表
public class MultiplyTable{
	public static void main(String[] args){
		for(int i = 1; i <= 9; i++){
			for(int j = 1; j <= 9; j++){
				System.out.printf("%d * %d = %d  ", i, j, i * j);
			}
			System.out.printf("%n");
		}
	}
}