import java.io.*;
import java.net.*;

public class EServer {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000);
             Socket client = server.accept();
             BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
             PrintWriter output = new PrintWriter(client.getOutputStream(), true)) {

            System.out.println("Client connected!");
            String message;
            while ((message = input.readLine()) != null) {
                if (message.equalsIgnoreCase("exit")) break;
                output.println(message);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
