import java.util.Arrays;

public class MyArrayList{
	private int[] a;
	private int size;
	
	public MyArrayList(int n){
		a = new int[n];
		size = 0;
	}
	//在顺序表尾部插入一个数字
	public void pushback(int element){
		a[size] = element;
		size++;
	}
	//删除顺序表尾部的数字
	public void deletback(){
		--size;
		a[size] = 0;
	}
	//在顺序表头部插入一个数字
	public void pushFront(int element){
		for(int i = size; i >= 1; i--){
			a[i] = a[i - 1];
		}
		a[0] = element;
		size++;
	}
	//删除顺序表头部的一个数字
	public void deletFront(){
		a[0] = 0;
		for(int i = 1; i < size; i++){
			a[i - 1] = a[i];
		}
		size--;
	}
	//给定一个下标在顺序表中给定下标的位置插入一个数字
	public void insert(int element, int index){
		if(index < 0 || index > size){
			System.out.println("输入下标范围不正确");
			return;
		}
		for(int i = size - 1; i >= index; i--){
			a[i + 1] = a[i];
		}
		a[index] = element;
		size++;
	}
	@Override
	public String toString(){
		return Arrays.toString(Arrays.copyOf(a, size));
	}
	
	public static void main(String[] args){
		MyArrayList list = new MyArrayList(10);
		list.pushback(1);
		list.pushback(2);
		list.pushback(3);
		System.out.println(list);    //此时的顺序表应为[1, 2, 3]
		list.pushFront(10);
		list.pushFront(20);
		list.pushFront(30);
		System.out.println(list);    //此时的顺序表应为[30, 20, 10, 1, 2, 3]
		list.insert(44, 2);
		System.out.println(list);    //此时的顺序表应为[30, 20, 44, 10, 1, 2, 3]
		list.insert(55, 0);
		System.out.println(list);    //此时的顺序表应为[55, 30, 20, 44, 10, 1, 2, 3]
		list.deletback();
		System.out.println(list);    //此时的顺序表应为[55, 30, 20, 44, 10, 1, 2]
		list.deletFront();           
		System.out.println(list);    //此时的顺序表应为[30, 20, 44, 10, 1, 2]
	}
}