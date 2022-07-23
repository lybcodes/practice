package Socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Server {
    //单线程服务器，一次只能处理一个客户端
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(6666)) {
            System.out.println("Listening on "
                    + serverSocket.getLocalSocketAddress());
            while(true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Incoming connection from "
                        + clientSocket.getRemoteSocketAddress());
                try (Scanner input = new Scanner(clientSocket.getInputStream())) {
                    while (true) {
                        String request = input.nextLine();
                        if (request.equals("quit")) {
                            break;
                        }
                        String response = "Hello " + request + ".\n";
                        clientSocket.getOutputStream().write(response.getBytes(StandardCharsets.UTF_8));
                    }
                }
            }
        }
    }
}
