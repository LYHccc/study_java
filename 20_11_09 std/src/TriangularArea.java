/*
 *���������
 *��֪����������������ֱ������ϵ�µ�����ֱ�Ϊ��(2.3, 2.5),(6.4, 3.1),(5.1, 7.2)����������ε������
 *ע�⣬Ҫ�ύ����һ��С����ʽ��ʾ�ĸ�������
 *Ҫ��ȷ��С����3λ���粻��3λ����Ҫ���㡣
 */
//���׹�ʽֱ�Ӽ���
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
