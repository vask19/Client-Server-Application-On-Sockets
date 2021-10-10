package server;
import resources.ServerData;

import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Server {
    private static int clientCount = 0;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(ServerData.SERVER_PORT,50,InetAddress.getByName(ServerData.SERVER_PATH)))
        {
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader reader = new BufferedReader(
                             new InputStreamReader(clientSocket.getInputStream()));
                     BufferedWriter writer = new BufferedWriter(
                             new OutputStreamWriter(clientSocket.getOutputStream())))
                {
                    String request = reader.readLine();
                    System.out.println(request);


                    writer.write("HTTP/1.0 200 OK\n" +
                            "Content-type: text/html\n" +
                            "\n"  +
                            "<h1>Hello</h1>\n");
                    writer.flush();
                    System.out.printf("Client %d accepted\n",++clientCount);

                }
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
