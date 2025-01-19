import java.io.*;
import java.net.*;
class ARPClient {
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            Socket clientSocket = new Socket("127.0.0.1", 1399);
            DataInputStream dIn = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream dOut = new DataOutputStream(clientSocket.getOutputStream());

            System.out.println("Enter the Logical Address (IP):");
            String logicalAddress = in.readLine();
            dOut.writeBytes(logicalAddress + '\n');

            String physicalAddress = dIn.readLine();
            System.out.println("The Physical Address is: " + physicalAddress);

            clientSocket.close();
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
}