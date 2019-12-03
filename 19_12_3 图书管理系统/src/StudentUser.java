import java.util.Scanner;

public class StudentUser extends User {
    @Override
    public void menu() {
        System.out.println("1.借书");
        System.out.println("2.还书");
        System.out.println("3.现有书籍展示");
    }

    @Override
    public void operation(int select) {
        switch (select){
            case 1:
                borrowBook();
                break;
            case 2:
                returnBook();
                break;
            case 3:
                listBook();
                break;
        }
    }
    //借书
    private void borrowBook(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要借的书籍");
        String title = scanner.nextLine();

        //创建一个BookShelf类型的对象
        BookShelf bookShelf = BookShelf.getBookShelf();
        //调用getBooks()方法将书籍信息存储在book[]中
        Book[] book = bookShelf.getBooks();
        //遍历book[]数组，根据书名查找
        //如果找到与要借书籍相同的书，判断是否还有这本书（如果有借阅成功，现有书数量减一，如果没有提示没书了）
        //如果没有找到提示没有这本书
        for(Book b : book){
            if(b.title.equals(title)){
                if(b.currentCount > 0){
                    b.currentCount--;
                    System.out.println("借书完成");
                    return;
                }else{
                    System.out.println("抱歉！书籍存货量不足，无法完成借阅");
                    return;
                }
            }
        }
        System.out.println("抱歉！查无此书");
    }
    //还书
    private void returnBook(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要还的书籍");
        String title = scanner.nextLine();

        //创建一个BookShelf类型的对象
        BookShelf bookShelf = BookShelf.getBookShelf();
        //调用getBooks()方法将书籍信息存储在book[]中
        Book[] book = bookShelf.getBooks();
        //遍历根据书名查找
        //找到还书，现有书数量加一
        //没找到提示没找到这本书
        for(Book b : book){
            if(b.title.equals(title)){
                b.currentCount++;
                System.out.println("还书成功！");
            }
        }
        System.out.println("查无此书！请重新确认要还的书籍");
    }
    //现有书展示
    private void listBook(){
        //创建一个BookShelf类型的对象
        BookShelf bookShelf = BookShelf.getBookShelf();
        //调用getBooks()方法将书籍信息存储在book[]中
        Book[] book = bookShelf.getBooks();
        //打印书籍的信息
        System.out.println("书名  当前数量  总数量");
        for(Book arr : book){
            System.out.println(arr.title + " " + arr.currentCount + " " + arr.totalCount);
        }
    }
}
