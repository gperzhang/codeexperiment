package io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class BIOClient {
    Socket socket;
    public BIOClient(){
        try {
            socket = new Socket("localhost",8080);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        BIOClient bioClient = new BIOClient();
        bioClient.sendMsg();
        //bioClient.recevie();


    }
    public  void sendMsg(){
        OutputStream outputStream =null;
        try {

            outputStream = socket.getOutputStream();

            String s = "你好，我是client端";
            outputStream.write(s.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(outputStream!=null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void recevie(){
        try {
            InputStream inputStream = socket.getInputStream();
            byte [] by = new byte[1024];
            int len =0;
            if ((len=inputStream.read(by))>0){
                System.out.println(new String(by,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
