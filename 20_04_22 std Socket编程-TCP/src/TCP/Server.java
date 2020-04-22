package TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static class ServiceThread extends Thread{
        private final Socket socket;

        public ServiceThread(Socket socket){
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                //获取输入流
                InputStream is = socket.getInputStream();
                //封装成Scanner
                Scanner scanner = new Scanner(new InputStreamReader(is, "UTF-8"));

                //接收一个请求
                String request = scanner.nextLine();
                System.out.println("收到请求:" + request);

                //生成响应，收到什么响应什么
                String response = request;
                //获取输出流
                OutputStream os = socket.getOutputStream();
                //封装成PrintWrite
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(os, "UTF-8"));
                //发送响应
                writer.println(response);
                writer.flush();

                socket.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);

        ExecutorService threadPool = Executors.newFixedThreadPool(20);
        //循环处理业务
        while(true){
            //获取连接
            Socket socket = serverSocket.accept();
            /*
            // 所有业务处理的过程，交给线程去处理
            new ServiceThread(socket).start();
            */
            threadPool.execute(new ServiceThread(socket));
        }
    }
}
