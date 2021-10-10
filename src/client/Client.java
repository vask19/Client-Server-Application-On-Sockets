package client;

import resources.ServerData;

import java.net.*;
import java.io.*;
public class Client {

    public static void main(String[] args) {
        try (Socket clientSocket = new Socket(ServerData.SERVER_PATH,ServerData.SERVER_PORT))
        {
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));
                 OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream())) {
                writer.write("Get me some information\n");
                writer.flush();
                System.out.println(reader.readLine());
                clientSocket.close();
            }
        }

        catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
