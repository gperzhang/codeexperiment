package io.bio.test.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Scanner;

public class NIOServer {
    public static void main(String[] args) throws IOException {
        NIOServer nioServer = new NIOServer();
        nioServer.init();
        //监听客户端发送来的数据
        new Thread(new ListenClient(nioServer.selector)).start();
        while (true){
            Scanner scanner = new Scanner(System.in);
            String word = scanner.nextLine();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byteBuffer.put(word.getBytes());
            byteBuffer.flip();
            nioServer.socketChannel.write(byteBuffer);
            byteBuffer.clear();
        }

    }

    private Selector selector;

    private static SocketChannel socketChannel;

    public void init(){
        try {
            //获取serverSocket通道
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            //设置为非阻塞，默认为阻塞
            serverSocketChannel.configureBlocking(false);
            //将serverSocket绑定到端口上
            serverSocketChannel.bind(new InetSocketAddress(8080));
            //获取一个选择器，通道管理器
            selector = Selector.open();
            //将通道管理器和通道绑定，并为改通道注册op_accept事件，当事件到达后selector.select()
            //会返回，否则一直处于阻塞状态。
            serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     static class ListenClient implements Runnable{
        private  Selector selector;

        public ListenClient(Selector selector){
            this.selector = selector;

        }
        @Override
        public void run() {
            System.out.println("服务启动成功");
            while (true){
                try {
                    selector.select();
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()){
                        SelectionKey selectionKey = iterator.next();
                        iterator.remove();
                        process(selectionKey);

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        private void process(SelectionKey selectionKey) {
            if(selectionKey.isAcceptable()){
                ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
                try {
                    socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    System.out.println("新的客户端连接成功，可以进行对话了");
                    socketChannel.register(selector,SelectionKey.OP_READ);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(selectionKey.isReadable()){
                socketChannel = (SocketChannel) selectionKey.channel();
                ByteBuffer allocate = ByteBuffer.allocate(1024);
                try {
                    int read = socketChannel.read(allocate);
                    if(read>0){
                        //被byteBuffer.array()方法坑了，返回的是整个长度，导致后面全是有空格
                        allocate.flip();
                        byte [] bytes =new byte[allocate.remaining()];
                        allocate.get(bytes);
                        String msg = new String(bytes,"utf-8");
                        System.out.println("Client:"+msg);
                        //socketChannel.register(selector,SelectionKey.OP_WRITE);

                    }else {
                        System.out.println("客户端关闭");
                        selectionKey.cancel();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
//               if(selectionKey.isWritable()){
//                try {
//                    socketChannel = (SocketChannel) selectionKey.channel();
//                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
//                    Scanner scanner = new Scanner(System.in);
//                    String readLine = scanner.nextLine();
//                    byteBuffer.put(readLine.getBytes());
//                    //把limit = position，position置为零，
//                    byteBuffer.flip();
//                    socketChannel.write(byteBuffer);
//                    //写完之后再注册为可读事件
//                    socketChannel.register(selector,SelectionKey.OP_READ);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//
//
//            }
        }

    }

}
