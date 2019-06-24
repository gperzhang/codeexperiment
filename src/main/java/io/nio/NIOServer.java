package io.nio;

import com.sun.xml.internal.stream.util.BufferAllocator;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {
    private int port;

    private Selector selector;

    ByteBuffer buffer = ByteBuffer.allocate(1024);

    public NIOServer(int port){
        this.port = port;
        try {
            ServerSocketChannel server = ServerSocketChannel.open();
            ServerSocketChannel bind = server.bind(new InetSocketAddress(port));
            server.configureBlocking(false);
            selector = Selector.open();

            SelectionKey register = server.register(selector,SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void listen(){
        System.out.println("开始监听端口"+this.port);
        while(true){
            try {
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()){
                    SelectionKey next = iterator.next();
                    iterator.remove();
                    process(next);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void process(SelectionKey key) throws IOException {
        if(key.isAcceptable()){
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(false);
            key = socketChannel.register(selector,SelectionKey.OP_READ);
        }else if(key.isReadable()){
            SocketChannel channel= (SocketChannel) key.channel();
            int read = channel.read(buffer);
            if(read>0){
                buffer.flip();
                String content = new String(buffer.array(),0,read);
                System.out.println("NIO 接受到的消息"+content);
            }
        }else if (key.isWritable()){}
    }

    public static void main(String[] args) {
        new NIOServer(8080).listen();
    }
}
