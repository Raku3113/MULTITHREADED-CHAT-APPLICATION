import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    private static Vector<ClientHandler> clients = new Vector<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server started on port 1234...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected: " + clientSocket);

            ClientHandler clientThread = new ClientHandler(clientSocket, clients);
            clients.add(clientThread);
            clientThread.start();
        }
    }
}