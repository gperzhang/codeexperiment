package io.bio.test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    private static final  int port = 8080;

    private static final String address = "127.0.0.1";

    public static void main(String[] args)  {
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            //测试阻塞场景下，服务端无法拿到数据的时候
            //System.in.read();
            socket = new Socket(address, port);

            outputStream = socket.getOutputStream();
            String s = "我是客户端";
            outputStream.write(s.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }
}
