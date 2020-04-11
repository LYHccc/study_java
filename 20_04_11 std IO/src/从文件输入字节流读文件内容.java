import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class 从文件输入字节流读文件内容 {
    public static void main(String[] args) throws IOException{
        try(InputStream input = new FileInputStream("从文件输入字节流读英文内容.txt")){
            byte[] buffer = new byte[1024];
            int len = input.read(buffer);
            StringBuilder str = new StringBuilder();
            for(int i = 0; i < len; i++){
                str.append((char)buffer[i]);
            }

            System.out.println(str.toString());
        }
    }
}
