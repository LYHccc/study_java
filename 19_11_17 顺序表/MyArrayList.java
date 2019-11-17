import java.util.Arrays;

public class MyArrayList{
	private int[] arr;
	private int size;
	public MyArrayList(int n){
		arr = new int[n];
		size = 0;
	}
	//给出下标，插入数据
	public void insert(int index, int element){
		if(!checkCapacity(1)){
			ensureCapacity();
		}
		for(int i = size; i > index; i--){
			arr[i] = arr[i - 1];
		}
		arr[index] = element;
		size++;
	}
	//判断容量是否够用
	private boolean checkCapacity(int num){
		if(num + size > arr.length){
			return false;
		}else{
			return true;
		}
	}
	//扩容
	private void ensureCapacity(){
		int[] newarr = new int[arr.length * 2];
		for(int i = 0; i < size; i++){
			newarr[i] = arr[i];
		}
		this.arr = newarr;
	}
	@Override
	public String toString(){
		return Arrays.toString(Arrays.copyOf(arr, size));
	}
	public static void main(String[] args){
		MyArrayList list = new MyArrayList(3);
		list.insert(0, 1);
		list.insert(0, 2);
		System.out.println(list.arr.length);
		list.insert(0, 3);
		System.out.println(list.arr.length);
		list.insert(0, 4);
		System.out.println(list.arr.length);
		list.insert(0, 5);
		System.out.println(list);
	}
}