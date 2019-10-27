public class JavaPractice{
	public static void main(String[] args){
		/*if(args.length < 2){
			System.out.println("请输入两个数字");
			return;
		}
		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		int result = x + y;
		System.out.println("" + x + "+" + y +"相加的结果是" + result);
		System.out.printf("%d+%d 相加的结果是%d%n", x, y, result);
		*/
		
		/*{
			int x = 10;
			System.out.printf("%d%n", x);
		}
		*/
		
		String s = "12345";
		System.out.println(Integer.parseInt(s));
		System.out.println(Long.parseLong(s));
		System.out.println(Double.parseDouble(s));
	}
}