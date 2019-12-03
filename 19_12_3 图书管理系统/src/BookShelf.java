import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookShelf {
    private static final BookShelf instance = new BookShelf();
    private BookShelf(){}

    public static BookShelf getBookShelf(){
        return instance;
    }

    //创建一个线性表存放书籍
    List<Book> list = new ArrayList<>();

    //添加一本书
    public void add(Book book){
        list.add(book);
    }

    //返回一个存储书籍信息的数组
    public Book[] getBooks(){
        Book[] book = new Book[list.size()];
        list.toArray(book);
        return book;
    }

    //给定书名移除这本书
    public void remove(String title){
        //1.找下标删除
        //removeIndex代表遍历到的下标
        int removeIndex = -1;
        for(int i = 0; i < list.size(); i++){
            //找到当前遍历到的位置的对象
            Book book = list.get(i);
            //用这个对象的书名与要去除的书名比较，如果相等说明找到要去除的书，将下标置为此时的值
            if(book.title.equals(title)){
                removeIndex = i;
                break;
            }
        }
        //如果下标不为-1，说明找到了要去除的书，删除它
        if(removeIndex != -1){
            list.remove(removeIndex);
        }
        /*
        //2.运用迭代器删除
        //用迭代器来遍历此时的线性表list
        Iterator<Book> it = list.iterator();
        while(it.hasNext()){
            Book book = it.next();
            if(book.title.equals(title)){
                it.remove();
            }
        }
        */
    }
}
