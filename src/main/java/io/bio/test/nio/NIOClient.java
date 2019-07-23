package io.bio.test.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

public class NIOClient {

    public static void main(String[] args) throws IOException {
        NIOClient nioClient = new NIOClient();
        nioClient.init();
        //启动一个线程监听服务端返回的数据
        new Thread(new ListenServer(nioClient.socketChannel,nioClient.selector)).start();
        while (true){
            Scanner scanner = new Scanner(System.in);
            String word = scanner.nextLine();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byteBuffer.put(word.getBytes());
            byteBuffer.flip();
            nioClient.socketChannel.write(byteBuffer);
            byteBuffer.clear();
        }
    }
    private Selector selector;
    private SocketChannel socketChannel;
    public void init (){
        try {
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("192.168.245.128",8080));
            selector = Selector.open();
            socketChannel.register(selector,SelectionKey.OP_READ );
            System.out.println(socketChannel.finishConnect());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static class ListenServer implements Runnable{
        private Selector selector;
        private SocketChannel socketChannel;
        public  ListenServer(SocketChannel socketChannel,Selector selector){
            this.selector = selector;
            this.socketChannel = socketChannel;

        }

            @Override
            public void run() {
                while (true){
                    try {
                        selector.select();
                        Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                        while (iterator.hasNext()){
                            SelectionKey next = iterator.next();
                            iterator.remove();
                            handler(next);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        private void handler(SelectionKey next) {
            if(next.isReadable()){
                socketChannel = (SocketChannel) next.channel();
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                try {
                    int read = socketChannel.read(byteBuffer);
                    if(read>0){
                        byteBuffer.flip();
                        int remaining = byteBuffer.remaining();
                        byte[] bytes = new byte[remaining];
                        byteBuffer.get(bytes);
                        String response = new String(bytes,"utf-8");
                        System.out.println("Server:"+response);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
