//定义一个自行车类
//属性：颜色、当前速度、最高速度
//方法：涂漆（颜色）、加速()匀速加速，不能超过最高速度 、减速() 匀速减速，不能低于0
//方法：返回当前颜色()、返回当前速度
class Bike{
	private String color;
	private int speed;
	private int maxSpeed;
	//构造方法
	public Bike(){
		color = "黑色";
		speed = 0;
		maxSpeed = 133;
	}
	/*public Bike(String c){
		color = c;
		speed = 0;
		maxSpeed = 100;
	}*/
	//方法
	void setColor(String c){
		color = c;
	}
	void speedUp(){
		speed += 10;
		if(speed > maxSpeed){
			speed = maxSpeed;
		}
	}
	void speedDown(){
		speed -= 10;
		if(speed < 0){
			speed = 0;
		}
	}
	String getColor(){
		return color;
	}
	int getSpeed(){
		return speed;
	}
}

public class BikeDemo{
	public static void main(String[] args){
		Bike b = new Bike();
		System.out.println("刚初始化:");
		System.out.println("颜色是: " + b.getColor());
		System.out.println("速度数: " + b.getSpeed());
		
		b.setColor("红色");
		System.out.println("刷漆后颜色是：" + b.getColor());
		
		System.out.println("下坡加速:");
		for(int i = 0; i < 15; i++){
			b.speedUp();
			System.out.println(b.getSpeed());
		}
		
		System.out.println("上坡减速:");
		for(int i = 0; i < 15; i++){
			b.speedDown();
			System.out.println(b.getSpeed());
		}
	}
}