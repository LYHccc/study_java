import java.io.*;

public class 从文件输入字符流中读文件内容 {
    public static void main(String[] args) throws IOException {
        try (InputStream is = new FileInputStream("从文件输入字符流读文件内容.txt")) {
            try (Reader reader = new InputStreamReader(is, "UTF-8")) {
                /*
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int c = reader.read();
                    if (c == -1) {
                        break;
                    }

                    sb.append((char)c);
                }

                System.out.println(sb.toString());
                */

                StringBuilder sb = new StringBuilder();
                char[] buffer = new char[1];
                while (true) {
                    int len = reader.read(buffer);
                    if (len == -1) {
                        break;
                    }
                    sb.append(buffer, 0, len);
                }

                System.out.println(sb.toString());
            }
        }
    }
}
