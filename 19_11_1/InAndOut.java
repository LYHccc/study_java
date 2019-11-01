import java.util.Scanner;

public class InAndOut{
	public static void main(String[] args){
		//System.err.println("我是打印在标准错误上的");
		//System.out.println(System.in.read());
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			String s = scanner.next();
			//String s = scanner.nextLine();
			System.out.println(s);
		}
	}
}