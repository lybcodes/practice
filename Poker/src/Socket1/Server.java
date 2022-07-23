package Socket1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    //线程池实现多线程服务器
    public static void main(String[] args) throws IOException {
        //三个线程的线程池服务三个客户端
        ExecutorService executor = Executors.newFixedThreadPool(3);

        RequestHandler requestHandler = new RequestHandler();

        try (ServerSocket serverSocket = new ServerSocket(6666)) {
            System.out.println("Listening on "
                    + serverSocket.getLocalSocketAddress());
            while(true) {
                //这里是blocked，如果没有客户端链接进来就一直阻塞等待
                Socket clientSocket = serverSocket.accept();
                System.out.println("Incoming connection from "
                        + clientSocket.getRemoteSocketAddress());
                executor.submit(new ClientHandler(clientSocket, requestHandler));
            }
        }
    }
}
