//定义一个书类
//属性：书名、作者、价格、出版社
//方法：getter/setter()、添加新的作者()、打折-返回折扣后价格()
class Book{
	private String title;
	private String author;
	private double price;
	private String press;
	//构造方法，初始化
	public Book(String title, String author, double price, String press){
		this.title = title;
		this.author = author;
		this.price = price;
		this.press = press;
	}
	//setter
	void setterTitle(){
		this.title = title;
	}
	void setterAuthor(){
		this.author = author;
	}
	void setterPrice(){
		this.price = price; 
	}
	void setter(){
		this.press = press;
	}
	//getter
	String getterTitle(){
		return title;
	}
	String getterAuthor(){
		return author;
	}
	double getterPrice(){
		return price;
	}
	String getterPress(){
		return press;
	}
	//添加一个新的作者
	public void addAuthor(String author){
		this.author = this.author + " " + author;
	}
	//打折-返回折扣后价格
	public double getDiscount(double discount){
		return this.price * discount; 
	}
	@Override
	public String toString(){
		return String.format("《%s》by %s", title, author);
	}
}

public class BookPractice{
	public static void main(String[] args){
		Book book = new Book("java从入门到精通", "Bruce Eckel", 60, "MindView");
		System.out.println(book);
		System.out.println(book.getDiscount(0.85));
		Book book1 = new Book("钢铁是怎么炼成的", "奥斯特洛夫斯基", 100, "商务出版社");
		System.out.println(book1);
		System.out.println(book1.getDiscount(1.5));
	}
}