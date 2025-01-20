import java.net.*;
import java.util.*;

public class UDPServerExp4b {
    public static void main(String[] args) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9902);
             Scanner sc = new Scanner(System.in);
            byte[] buffer = new byte[1024];
            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                serverSocket.receive(packet);
                String clientData = new String(packet.getData(), 0, packet.getLength()).trim();
                System.out.println("\nClient: " + clientData);
                System.out.print("Server: ");
                String serverData = sc.nextLine();
                serverSocket.send(new DatagramPacket(serverData.getBytes(), serverData.length(), packet.getAddress(), packet.getPort()));
                if (serverData.equalsIgnoreCase("bye")) {
                    System.out.println("Connected");
                    break;
                }
            }
        }
    }
