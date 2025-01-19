import java.io.*;
import java.net.*;

public class EServerExp4a {
    public static void main(String[] args) throws IOException {
        try (
                ServerSocket server = new ServerSocket(9000);
                Socket client = server.accept();
                BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter output = new PrintWriter(client.getOutputStream(), true);
                ){
            System.out.println("Connected!");
            String msg;
            while((msg= input.readLine())!=null){
                if (msg.equalsIgnoreCase("exit")) break;
                output.println(msg);
            }
        }
    }
}