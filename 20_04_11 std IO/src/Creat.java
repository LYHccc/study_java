import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Creat {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        File file = new File("动漫.txt");
        System.out.println("对象创建成功");

        System.out.println("输入回车创建文件夹");
        scanner.nextLine();
        file.mkdir();
        System.out.println("创建成功");

        System.out.println("输入回车删除文件夹");
        scanner.nextLine();
        file.delete();
    }
}
