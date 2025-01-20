import java.io.*;
import java.net.*;

public class EClientExp4a {
    public static void main(String[] args) throws IOException {
        try(
                Socket client = new Socket(InetAddress.getLocalHost(), 9000);
                BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader serverInput = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter serverOutput = new PrintWriter(client.getOutputStream(), true);
                ){
            String msg;
            while(true){
                System.out.print("\nClient: ");
                msg = userInput.readLine();
                serverOutput.println(msg);
                if(msg.equalsIgnoreCase("exit")) break;
                System.out.print("Server: " + serverInput.readLine());
            }
        }
    }
}