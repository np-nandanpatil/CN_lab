import java.io.*;
import java.net.*;

public class EClient {
    public static void main(String[] args) {
        try (Socket client = new Socket(InetAddress.getLocalHost(), 9000);
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader serverInput = new BufferedReader(new InputStreamReader(client.getInputStream()));
             PrintWriter serverOutput = new PrintWriter(client.getOutputStream(), true)) {

            String message;
            while (true) {
                System.out.print("Client: ");
                message = userInput.readLine();
                serverOutput.println(message);
                if (message.equalsIgnoreCase("exit")) break;
                System.out.println("Server: " + serverInput.readLine());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
