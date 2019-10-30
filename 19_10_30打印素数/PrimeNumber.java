//打印100~200之间的素数
public class PrimeNumber{
	public static void main(String[] args){
		int Num = 0;
		int n = 0;
		//Num作为被除数从100递增到200，依次进行素数的判断
		for(Num = 100; Num <= 200; Num++){
			//n作为除数从2递增到Num
			for(n = 2; n <= Num; n++){
				//如果Num除以n取余不为零说明Num不是素数，结束此次循环，
				if(Num % n == 0)break;
			}
			//如果此时的Num等于n说明n递增到num才结束，在num之前没有能够取余为零的数，说明这个Num为素数。
			if(Num == n){
				System.out.printf("%d ",Num);
			}
		}
	}
}