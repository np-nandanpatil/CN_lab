import java.io.*;
import java.net.*;
class ARPServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1399);
            Socket clientSocket = serverSocket.accept();

            while (true) {
                DataInputStream clientIn = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream clientOut = new DataOutputStream(clientSocket.getOutputStream());

                String requestedIP = clientIn.readLine();

                String[] ipAddresses = {"165.165.80.80", "165.165.79.1"};
                String[] macAddresses = {"6A:08:AA:C2", "8A:BC:E3:FA"};

                for (int i = 0; i < ipAddresses.length; i++) {
                    if (requestedIP.equals(ipAddresses[i])) {
                        clientOut.writeBytes(macAddresses[i] + '\n');
                        break;
                    }
                }

                serverSocket.close();
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
}