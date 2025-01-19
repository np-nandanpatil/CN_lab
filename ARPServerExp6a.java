import java.io.*;
import java.net.*;
class ARPServerExp6a {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(1399);
        String[] ipAddresses = {"165.165.80.80", "165.165.79.1"};
        String[] macAddresses = {"6A:08:AA:C2", "8A:BC:E3:FA"};
        while (true) {
            Socket clientSocket = serverSocket.accept();
            DataInputStream clientIn = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream clientOut = new DataOutputStream(clientSocket.getOutputStream());
            String requestedIP = clientIn.readLine();
            for (int i = 0; i < ipAddresses.length; i++)
                if (requestedIP.equals(ipAddresses[i])) {
                    clientOut.writeBytes(macAddresses[i] + '\n');
                    break;
                }
            clientSocket.close();
        }
    }
}