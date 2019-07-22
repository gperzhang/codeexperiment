package io.bio.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Handler implements Runnable {
    private Socket socket;
    public Handler(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
            int available = inputStream.available();
            byte [] bytes = new byte[available];
            inputStream.read(bytes);//将输入流读进内存中去
            String content = new String(bytes,"utf-8");
            System.out.println("接受到客户端的数据-------"+content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
