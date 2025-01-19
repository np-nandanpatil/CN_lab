import java.net.*;
import java.util.*;

public class UDPClientExp4b {
    public static void main(String[] args) throws Exception {
        try (DatagramSocket clientSocket = new DatagramSocket();
             Scanner sc = new Scanner(System.in)) {
            InetAddress ip = InetAddress.getByName("localhost");
            byte[] buffer = new byte[1024];
            while (true) {
                System.out.print("\nClient: ");
                String clientData = sc.nextLine();
                clientSocket.send(new DatagramPacket(clientData.getBytes(), clientData.length(), ip, 9902));
                if (clientData.equalsIgnoreCase("bye")) {
                    System.out.println("connection end by client");
                    break;
                }
                DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
                clientSocket.receive(receivePacket);
                String serverData = new String(receivePacket.getData(), 0, receivePacket.getLength()).trim();
                System.out.println("Server: " + serverData);
            }
        }
    }
}