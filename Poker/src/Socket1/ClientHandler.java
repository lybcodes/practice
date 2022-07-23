package Socket1;

import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ClientHandler implements Runnable{
    private final Socket clientSocket;
    private final RequestHandler requestHandler;

    public ClientHandler(Socket clientSocket, RequestHandler requestHandler){
        this.clientSocket = clientSocket;
        this.requestHandler = requestHandler;
    }

    @Override
    public void run() {
        try (Scanner input = new Scanner(clientSocket.getInputStream())) {
            while (true) {
                //这里也是blocked，没有输入就一直阻塞等待
                String request = input.nextLine();
                if (request.equals("quit")) {
                    break;
                }
                String response = requestHandler.handle(request);
                clientSocket.getOutputStream().write(response.getBytes(StandardCharsets.UTF_8));
            }
        }catch (IOException e){
            System.out.println("Caught exception: " + e);
            throw new RuntimeException(e);
        }
    }
}
