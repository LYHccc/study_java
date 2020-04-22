package TCP;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 9000);

        //产生请求
        Scanner console = new Scanner(System.in);
        System.out.print("请输入请求:");
        String request = console.nextLine();

        //获取输出流
        OutputStream os = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(os, "UTF-8"));
        //发送请求
        writer.println(request);
        writer.flush();

        //获取输出流
        InputStream is = socket.getInputStream();
        Scanner scanner = new Scanner(new InputStreamReader(is, "UTF-8"));
        // 对象没有响应，就一直等
        String respose = scanner.nextLine();
        System.out.println("收到响应:" + respose);

        socket.close();
    }
}
