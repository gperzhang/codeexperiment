package io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class BIOServer {
    private  ServerSocket serverSocket;
    public static void main(String[] args) {
        new BIOServer(8080).listen();
    }
    public BIOServer(int port){
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("监听端口。。。。"+port+"已启动");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void listen(){
        while(true){
        try {
            Socket server = serverSocket.accept();
            InputStream inputStream = server.getInputStream();
            byte [] bt = new byte[1024];
            int len =0;
            String content = "";
            while ((len=inputStream.read(bt))>0){
                content += new String(bt,0,len);
            }
            System.out.println("收到客户端发来的消息"+content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
}
