import java.util.Scanner;

public class TeatherUser extends User {
    @Override
    public void menu() {
        System.out.println("1.上架书籍");
        System.out.println("2.下架书籍");
        System.out.println("3.现有书籍展示");
    }

    @Override
    public void operation(int select) {
        switch (select){
            case 1:
                addBook();
                break;
            case 2:
                removeBook();
                break;
            case 3:
                listBook();
                break;
        }
    }

    //上架书籍
    private void addBook(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("上架的书籍名称");
        String title = scanner.nextLine();
        System.out.println("上架的书籍数量");
        int count = scanner.nextInt();

        Book book = new Book();
        book.title = title;
        book.totalCount = count;
        book.currentCount = count;

        //创建一个BookShelf类型的对象
        BookShelf bookShelf = BookShelf.getBookShelf();
        //调用add()方法添加一本书籍
        bookShelf.add(book);
        System.out.println("上架成功");
    }

    //下架书籍
    private void removeBook(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("下架的书籍名称");
        String title = scanner.nextLine();

        //创建一个BookShelf类型的对象
        BookShelf bookShelf = BookShelf.getBookShelf();
        //调用add()方法添加一本书籍
        bookShelf.remove(title);
        System.out.println("下架完成");
    }

    //现有书展示
    private void listBook(){
        //创建一个BookShelf类型的对象
        BookShelf bookShelf = BookShelf.getBookShelf();
        //调用getBooks()方法将书籍信息存储在book[]中
        Book[] book = bookShelf.getBooks();
        //打印书籍的信息
        System.out.println("书名,当前数量,总数量");
        for(Book arr : book){
            System.out.println(arr.title + "," + arr.currentCount + "," + arr.totalCount);
        }
    }
}
