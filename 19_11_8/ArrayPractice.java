import java.util.Arrays;

public class  ArrayPractice{
	public static int[] copyOfRange(int[] a, int from, int to){
		int[] b = new int[to - from];
		for(int i = from; i < to; i++){
			b[i - from] = a[i];
		}
		return b;
	}
	public static void arraycopy(int[] src, int srcPos, int[] dest, int destPos, int length){
	//src和dest是否指向同一个数组对象
	//如果指向同一个数组对象，在拷贝的时候，需要用一个新的数组保存要拷贝的内容，在将内容拷贝到指定数组中去
	//如果不知想同一个数组对象则直接进行相应位置的拷贝
	if(src == dest){
		int[] temArray = copyOfRange(src,srcPos,srcPos + length);
		for(int i = 0; i < length; i++){
			dest[destPos + i] = temArray[i];
		}
	}else{
		for(int i = 0; i <length; i++){
			dest[destPos + i] = src[srcPos + i];
		}
	}
}
	public static void main(String[] args){
		int[] a = {1, 5, 4, 2, 9, 8, 6, 3};
		int[] b = {1, 5, 4, 2, 9, 8, 6, 3};
		int[] c = {7, 7, 7, 7, 7, 7, 7, 7};
		System.out.println("拷贝前b数组为：");
		System.out.println(Arrays.toString(b));
		System.out.println("拷贝前c数组为：");
		System.out.println(Arrays.toString(c));
		//将a数组从下标为1的元素到下标为4的元素（即拷贝长度为4）进行拷贝，分别拷贝到b，c数组从下标2开始拷贝长度为4
		arraycopy(a, 1, b, 2, 4);
		arraycopy(a, 1, c, 2, 4);
		System.out.println("拷贝后b数组为：");
		System.out.println(Arrays.toString(b));
		System.out.println("拷贝后c数组为：");
		System.out.println(Arrays.toString(c));
		
	}
}