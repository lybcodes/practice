package Socket2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {
    //NIO  IO多路复用（单个线程/进程同时处理多个IO请求）
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel =
                ServerSocketChannel.open();
        //异步IO设置不blocked
        serverSocketChannel.configureBlocking(false);
        /**
         *  此时如果有客户链接进来返回一个channel，没有则返回null，直接调accept肯定返回null，
         *  所以这里通过selector选择，等有客户端想要链接的时候再去accept，不需要一直阻塞等待
         *  SocketChannel clientChannel = serverSocketChannel.accept();
         */

        serverSocketChannel.bind(new InetSocketAddress(8888));
        System.out.println("Listening on " + serverSocketChannel.getLocalAddress());
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while(true){
            int selected = selector.select();
            if(selected == 0){
                continue;
            }

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> it = selectionKeys.iterator();
            ByteBuffer buffer = ByteBuffer.allocate(1024);//建一个缓冲区来读数据
            RequestHandler requestHandler = new RequestHandler();

            while(it.hasNext()){
                SelectionKey key = it.next();
                if(key.isAcceptable()){
                    ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                    SocketChannel clientChannel = channel.accept();
                    System.out.println("Incoming connection from " + clientChannel.getRemoteAddress());
                    clientChannel.configureBlocking(false);
                    //这里就可以开始读数据了，同样通过selector选择有数据输入的channel，不需要阻塞等待数据输入
                    clientChannel.register(selector, SelectionKey.OP_READ);
                }
                if(key.isReadable()){
                    SocketChannel channel = (SocketChannel) key.channel();
                    channel.read(buffer);
                    String request = new String(buffer.array()).trim();
                    buffer.clear();
                    System.out.println(String.format(
                            "Request from %s: %s",
                            channel.getRemoteAddress(),
                            request
                    ));
                    String response = requestHandler.handle(request);
                    channel.write(ByteBuffer.wrap(response.getBytes()));
                }
                //处理完每个key要删掉，这也是为什么用iterator来做的原因
                it.remove();
            }
        }
    }
}
