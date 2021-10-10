package server;
import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Server {
    private static int clientCount = 0;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8000); )
        {
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
                     DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());)
                {
                    System.out.printf("Client %d accepted\n",++clientCount);
                    outputStream.writeUTF("<h2>Hello</h2>");
                    outputStream.flush();
                }
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
