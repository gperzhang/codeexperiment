package io.bio.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static final int port = 8080;

    public static void main(String[] args) {
        new Server().listen();
    }

    public void listen() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("服务端开始监听端口号："+port);
            while (true){
                //利用多线程优化bio阻塞问题，但是要为每一个请求开启一个线程，开销较大，可以使用线程池来优化
                Socket socket = serverSocket.accept();
                new Thread(new Handler(socket)).start();




//                Socket server = serverSocket.accept();
//                InputStream inputStream = server.getInputStream();
//                byte [] bt = new byte[1024];
//                int len =0;
//                String content = "";
//                while ((len=inputStream.read(bt))>0){
//                    content += new String(bt,0,len);
//                }
//                System.out.println("接受到客户端的数据为：："+content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
